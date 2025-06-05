import React from 'react'
import { NavLink } from 'react-router-dom'
import { Button, Menu } from 'semantic-ui-react'

export default function Categories() {
  return (
    <div>
      <Menu color='blue' fixed='left' pointing vertical style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100vh',zIndex: 100 }}>
        <Menu.Item><NavLink to="/events/soccer"><Button fluid color='green'>Soccer</Button></NavLink></Menu.Item>
        <Menu.Item><NavLink to="/events/basketball"><Button fluid color='green'>Basketball</Button></NavLink></Menu.Item>
        <Menu.Item><NavLink to="/events/voleyball"><Button fluid color='green'>Voleyball</Button></NavLink></Menu.Item>
        <Menu.Item><NavLink to="/events/tennis"><Button fluid color='green'>Tennis</Button></NavLink></Menu.Item>
      </Menu>
    </div>
  )
}
