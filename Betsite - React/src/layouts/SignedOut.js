import React from 'react'
import { NavLink } from 'react-router-dom'
import { Button ,Menu } from 'semantic-ui-react'

export default function SignedOut() {
  return (
    <div>
      <Menu.Item>
        <NavLink to="/login"><Button primary>Login</Button></NavLink>
        <NavLink to="/signup"><Button primary style={{marginLeft:'0.5em'}}>Sign Up</Button></NavLink>
      </Menu.Item>
    </div>
  )
}
