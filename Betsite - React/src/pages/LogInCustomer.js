import React, { useEffect, useState } from 'react'
import { Formik, Form, Field, ErrorMessage } from "formik"
import { FormField, Button, Label } from 'semantic-ui-react'
import * as Yup from "yup"
import CustomerService from '../services/customerService'
import { useDispatch } from 'react-redux'
import { logIn } from '../store/actions/customerActions'

export default function LogInCustomer() {
    const dispatch = useDispatch()
    const initialValues = {
        user_id: "",
        customer_password: "",
    }
    const schema = Yup.object({
        user_id: Yup.string().required("Please fill the username"),
        customer_password: Yup.string().required("Please fill the password"),
    })
    const [customers, setCustomers] = useState([])
    useEffect(() => {
      let customerService = new CustomerService();
      customerService.getCustomers().then(result=>setCustomers(result.data))
    }, [])
    return (
        <Formik
            initialValues={initialValues}
            validationSchema={schema}
            onSubmit={(values) => {
                customers.map((customer)=>{
                    if(customer.user_id===values.user_id&&customer.customer_password===values.customer_password)
                    {
                        dispatch(logIn(customer,true))
                    }
                    
                })
            }}
        >
            <Form>
                <FormField position="fixed" className='ui-form'>
                    <Label>Username</Label>
                    <Field name="user_id"></Field>
                    <ErrorMessage name="user_id" render={error =>
                        <Label basic color='red' pointing="left">{error}</Label>
                    }></ErrorMessage>
                </FormField>
                <FormField position="fixed">
                    <Label>Password</Label>
                    <Field name="customer_password"></Field>
                    <ErrorMessage name="customer_password" render={error =>
                        <Label basic color='red' pointing="left">{error}</Label>
                    }></ErrorMessage>
                </FormField>
                <Button type="submit" color='blue'>Login</Button>
            </Form>
        </Formik>
    )
}
