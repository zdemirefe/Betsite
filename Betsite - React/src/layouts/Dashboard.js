import React from 'react'
import EventList from '../pages/EventList'
import { Grid, GridColumn, GridRow } from 'semantic-ui-react'
import { Routes,Route } from 'react-router'
import Betslip from '../pages/Betslip'
import { ToastContainer } from 'react-toastify'
import AddCustomer from '../pages/AddCustomer'
import LogInCustomer from '../pages/LogInCustomer'
import SoccerEventList from '../pages/SoccerEventList'
import BasketballEventList from '../pages/BasketballEventList'
import VoleyballEventList from '../pages/VoleyballEventList'
import TennisEventList from '../pages/TennisEventList'
import Statistics from '../pages/Statistics'

export default function Dashboard() {
  return (
    <div>
      <ToastContainer position='bottom-right'/>
      <Grid>
        <GridRow>
          <GridColumn width={12}>
            <Routes>
              <Route exact path='/' element={<EventList/>}/>
              <Route exact path='/events' element={<EventList/>}/>
              <Route exact path='/mybetslips' element={<Betslip/>}/>
              <Route exact path='/signup' element={<AddCustomer/>}/>
              <Route exact path='/login' element={<LogInCustomer/>}/>
              <Route exact path='/events/soccer' element={<SoccerEventList/>}/>
              <Route exact path='/events/voleyball' element={<VoleyballEventList/>}/>
              <Route exact path='/events/basketball' element={<BasketballEventList/>}/>
              <Route exact path='/events/tennis' element={<TennisEventList/>}/>
              <Route exact path='/statistic' element={<Statistics/>}/>
            </Routes>
          </GridColumn>
        </GridRow>
      </Grid>
    </div>
  )
}
