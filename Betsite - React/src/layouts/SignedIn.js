import React, { useEffect, useState } from 'react'
import { useDispatch } from 'react-redux'
import { Dropdown, Menu, Image } from 'semantic-ui-react'
import { logOut } from '../store/actions/customerActions'
import { NavLink } from 'react-router-dom'

export default function SignedIn(props) {
  const dispatch = useDispatch()
  function handleLogOut() {
    dispatch(logOut({},false))
  }
  return (
    <div>
       <Menu.Item>
          <Image avatar spaced="right" src="https://media.licdn.com/dms/image/C4D03AQG3VYrKVck3iQ/profile-displayphoto-shrink_800_800/0/1661426462032?e=2147483647&v=beta&t=RX1qmTtj3QW_hGXPJhA442tzRVeYnqmzTelxaiuLpU8"/>
          <Dropdown pointing="top left"  text={props.customer.customer_name+" "+props.customer.customer_surname}>
            <Dropdown.Menu>
              <NavLink to="/statistic"><Dropdown.Item text = "Statistics" icon="chart bar"/></NavLink>
              <NavLink to="/mybetslips" end className="custom-link"><Dropdown.Item text = "My Betslips" icon="briefcase"/></NavLink>
              <Dropdown.Item text = {props.customer.customer_balance} icon="lira sign"/>
              <Dropdown.Item onClick={handleLogOut} text = "Sign Out" icon="sign-out"/>
            </Dropdown.Menu>
          </Dropdown>
       </Menu.Item>
    </div>
  )
}
