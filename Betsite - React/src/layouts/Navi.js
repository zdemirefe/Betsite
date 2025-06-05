import React, { useEffect, useState } from 'react'
import BetslipCart from './BetslipCart'
import { Container, Menu, Button } from 'semantic-ui-react'
import SignedIn from './SignedIn'
import SignedOut from './SignedOut'
import { NavLink, useNavigate } from 'react-router-dom'
import { useSelector } from 'react-redux';


export default function Navi() {
    const customer = useSelector(state => state.customer);
    const isAuthenticated=customer[1]
    const { cartItems } = useSelector(state => state.cart)
    const navigate = useNavigate()
    useEffect(() => {
      navigate("/")
    }, [isAuthenticated])
    
    return (
        <div>
            <Menu fixed="top">
                <Container>
                    <NavLink to="/"><Menu.Item><Button color='blue'>Home</Button></Menu.Item></NavLink>
                    <Menu.Menu position='right'>
                        {cartItems.length > 0 && <BetslipCart />}
                        {isAuthenticated ? <SignedIn customer={customer[0]}/> : <SignedOut/>}
                    </Menu.Menu>
                </Container>
            </Menu>
        </div>
    )
}
