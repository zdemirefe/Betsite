import React from 'react'
import { Formik, Form, Field, ErrorMessage } from "formik"
import { FormField, Button, Label } from 'semantic-ui-react'
import * as Yup from "yup"
import CustomerService from '../services/customerService'

export default function AddCustomer() {
    const initialValues = {
        customer_id:0,
        user_id: "",
        customer_name: "",
        customer_surname: "",
        customer_mail: "@ogr.deu.edu.tr",
        customer_password: "",
        customer_date: "",
        customer_gender: "",
        customer_balance: 0.0
    }
    const schema = Yup.object({
        user_id: Yup.string().required("Please fill the username"),
        customer_name: Yup.string().required("Please fill the name"),
        customer_surname: Yup.string().required("Please fill the surname"),
        customer_mail: Yup.string().required("Please fill the mail"),
        customer_password: Yup.string().required("Please fill the password"),
        customer_date: Yup.string().required("Please fill the date of birth"),
        customer_gender: Yup.string().required("Please fill the gender")
    })

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={schema}
            onSubmit={(values) => {
                let customerService = new CustomerService();
                customerService.postCustomer(values)
                console.log(values)
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
                    <Label>Name</Label>
                    <Field name="customer_name"></Field>
                    <ErrorMessage name="customer_name" render={error =>
                        <Label basic color='red' pointing="left">{error}</Label>
                    }></ErrorMessage>
                </FormField>
                <FormField position="fixed" >
                    <Label>Surname</Label>
                    <Field name="customer_surname"></Field>
                    <ErrorMessage name="customer_surname" render={error =>
                        <Label basic color='red' pointing="left">{error}</Label>
                    }></ErrorMessage>
                </FormField>
                <FormField position="fixed">
                    <Label>Mail Adress</Label>
                    <Field name="customer_mail"></Field>
                    <ErrorMessage name="customer_mail" render={error =>
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
                <FormField position="fixed">
                    <Label>Date of Birth</Label>
                    <Field name="customer_date"></Field>
                    <ErrorMessage name="customer_date" render={error =>
                        <Label basic color='red' pointing="left">{error}</Label>
                    }></ErrorMessage>
                </FormField>
                <FormField position="fixed">
                    <Label>Gender</Label>
                    <Field name="customer_gender"></Field>
                    <ErrorMessage name="customer_gender" render={error =>
                        <Label basic color='red' pointing="left">{error}</Label>
                    }></ErrorMessage>
                </FormField>
                <Button color='blue'>Sign Up</Button>
            </Form>
        </Formik>
    )
}
