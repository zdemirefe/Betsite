import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { NavLink } from 'react-router-dom';
import { Button, Dropdown, DropdownDivider, FormField, Label } from 'semantic-ui-react';
import EventService from '../services/eventService';
import { Formik, Form, Field, ErrorMessage } from "formik"
import * as Yup from "yup"
import BetslipService from '../services/betslipService';
import CustomerService from '../services/customerService';
import BetslipCustomerService from '../services/betslipCustomerService';


export default function BetslipCart() {
  const cartItem = useSelector(state => state.cart);
  const customer = useSelector(state => state.customer)
  let [total_ratio, setTotal_ratio] = useState()
  const [betslipcustomer, setBetslipcustomer] = useState([])
  const [bets, setBets] = useState([]);
  const [events, setEvents] = useState([]);
  useEffect(() => {
    let eventService = new EventService();
    eventService.getEvents().then(result => setEvents(result.data));
  }, [customer]);
  useEffect(() => {
    const updatedBets = cartItem.cartItems.map(bet => bet.bet);
    setTotal_ratio(1)
    setBetslipcustomer([])
    setBets(updatedBets);
  }, [cartItem.cartItems]);
  const initialValues = { betslip_amount: 20 }
  const schema = Yup.object({ betslip_amount: Yup.number().required("Please give to correct amount.") })
  return (
    <div>
      <Dropdown text='Betslip ' icon='eye' item style={{ color: 'green' }}>
        <Dropdown.Menu>
          {bets.map(item => (
            events.map((event) => {
              if (event.event_id === item.event_id) {
                { total_ratio = total_ratio * item.bet_ratio }
                {
                  betslipcustomer.push({
                    betslipcustomer_id: 0,
                    betslip_id: 0,
                    bet_id: item.bet_id
                  })
                }
                return <Dropdown.Item key={item.bet_id}><Label color='brown'>{event.home}</Label> <Label>{event.away}</Label><Label>{item.bet_type}</Label><Label color='blue'>{item.bet_ratio}</Label></Dropdown.Item>
              }
            })
          ))}
          <DropdownDivider />
          <Dropdown.Item>
            <Formik
              initialValues={initialValues}
              validationSchema={schema}
              onSubmit={(values) => {
                let betslip = {
                  "betslip_id": 0,
                  "customer_id": 0,
                  "total_ratio": total_ratio,
                  "betslip_amount": 0,
                  "betslip_situation": "Waiting"
                }
                let betslipService = new BetslipService()
                let customerService = new CustomerService()
                { customer[0].customer_balance = customer[0].customer_balance - values.betslip_amount }
                { betslip.customer_id = customer[0].customer_id }
                { betslip.betslip_amount = values.betslip_amount }
                { betslip.betslip_situation = "Waiting" }
                { betslip.betslip_id = 0 }
                console.log(betslip.total_ratio)
                betslipService.postBetslip(betslip)
                customerService.updateCustomer(customer[0])
                const postData = async (betslipcustomer) => {
                  let betslipCustomerService = new BetslipCustomerService();
                  console.log(betslipcustomer)
                  betslipCustomerService.postBetslipCustomer(betslipcustomer);
                }
                const fetchData = async () => {
                  let betslipService2 = new BetslipService();
                  let betslips2 = await betslipService2.getBetslipCustomerId(customer[0].customer_id);
                  let betslips3 = betslips2.data;
                  console.log(betslips3);
                  let ourbetslip = betslips3[betslips3.length - 1];
                  console.log("osman");
                  console.log(ourbetslip);
                  console.log(betslipcustomer)
                  betslipcustomer.map((betslipcustomer) => {
                    betslipcustomer.betslip_id = ourbetslip.betslip_id;
                    postData(betslipcustomer)
                  });
                };
                fetchData()
                setBetslipcustomer([])
              }}
            >
              <Form>
                <FormField position="fixed" className='ui-form'>
                  <Label>amount</Label>
                  <Field name="betslip_amount"></Field>
                  <ErrorMessage name="betslip_amount" render={error =>
                    <Label basic color='red' pointing="left">{error}</Label>
                  }></ErrorMessage>
                </FormField>
                <Button type="submit" fluid color='green'>Complete Betslip</Button>
              </Form>
            </Formik>
          </Dropdown.Item>
          <Dropdown.Item>
            xx
          </Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    </div>
  )
}
