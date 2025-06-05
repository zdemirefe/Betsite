import React, { useEffect, useState } from 'react';
import BetslipService from '../services/betslipService';
import { useSelector } from 'react-redux';
import BetService from '../services/betService';
import BetslipCustomerService from '../services/betslipCustomerService';
import {
  TableRow,
  TableHeaderCell,
  TableHeader,
  TableCell,
  TableBody,
  Icon,
  Table,
  Label
} from 'semantic-ui-react';
import EventService from '../services/eventService';

export default function Betslip() {
  const [betslips, setBetslips] = useState([]);
  const customer = useSelector((state) => state.customer);
  const [bets, setBets] = useState([]);
  const [events, setEvents] = useState([]);
  const [betslipsCustomer, setBetslipCustomer] = useState([]);
  let [finalBetslip, setFinalBetslip] = useState({
    betslip_amount: 0,
    betslip_situation: 'Waiting',
    total_ratio: 1,
    bets: [],
  });
  function groupXX(data) {
    const groupedData = data.reduce((accumulator, currentValue) => {
      const key = currentValue.betslip_id;

      if (!accumulator[key]) {
        accumulator[key] = [];
      }

      accumulator[key].push(currentValue);

      return accumulator;
    }, {});

    const resultArray = Object.values(groupedData);

    return resultArray;
  }
  let aa = groupXX(betslipsCustomer)
  useEffect(() => {
    let betslipCustomerService = new BetslipCustomerService();
    betslipCustomerService
      .getBetslipCustomer(customer[0])
      .then((result) => setBetslipCustomer(result.data));
    let betslipService = new BetslipService();
    let betService = new BetService();
    let eventService = new EventService();

    eventService.getEvents().then((result) => setEvents(result.data));
    betService.getBets().then((result) => setBets(result.data));
    betslipService
      .getBetslipCustomerId(customer[0].customer_id)
      .then((result) => setBetslips(result.data));

    aa = groupXX(betslipsCustomer)
    console.log(aa)
    setFinalBetslip({
      betslip_amount: 0,
      betslip_situation: 'Waiting',
      total_ratio: 1,
      bets: [],
    });
  }, [customer]);

  return (
    <div>
      {betslipsCustomer.map((betslipCustomer) => {
        betslips.map((betslip) => {
          if (betslipCustomer.betslip_id === betslip.betslip_id) {
            finalBetslip.betslip_amount = betslip.betslip_amount;
            finalBetslip.total_ratio = betslip.total_ratio;
            bets.map((bet) => {
              if (betslipCustomer.bet_id === bet.bet_id) {
                finalBetslip.bets.push(bet);
              }
            });
          }
        });
      })}

      {console.log(finalBetslip)}
      {console.log(finalBetslip.bets)}

      <Table>
        <TableHeader>
          <TableRow>
            <TableHeaderCell></TableHeaderCell>
            <TableHeaderCell>Home</TableHeaderCell>
            <TableHeaderCell>Away</TableHeaderCell>
            <TableHeaderCell>Bet Ratio</TableHeaderCell>
            <TableHeaderCell>Bet Type</TableHeaderCell>
            <TableHeaderCell>Situation</TableHeaderCell>
          </TableRow>
        </TableHeader>

        <TableBody>
          {finalBetslip.bets.map((bet) => (
            <TableRow key={bet.bet_id}>
              {events.map((event) => {
                if (event.event_id === bet.event_id) {
                  return (
                    <React.Fragment key={event.event_id}>
                      <TableCell><Icon color="green" name="tint"/></TableCell>
                      <TableCell>{event.home}</TableCell>
                      <TableCell>{event.away}</TableCell>
                      <TableCell>{bet.bet_ratio}</TableCell>
                      <TableCell>{bet.bet_type}</TableCell>
                      <TableCell>
                        <Icon color='green' name='wait' />
                      </TableCell>
                    </React.Fragment>
                  );
                }
                return null;
              })}
            </TableRow>
          ))}
          <TableCell><Label color="blue">Total Ratio</Label></TableCell>
          <TableCell>{finalBetslip.total_ratio}</TableCell>
          <TableCell><Label color="blue">Amount</Label></TableCell>
          <TableCell>{finalBetslip.betslip_amount}</TableCell>
          <TableCell><Label color="blue">Situation  </Label></TableCell>
          <TableCell>{finalBetslip.betslip_situation}</TableCell>
        </TableBody>
      </Table>
    </div>
  );
}
