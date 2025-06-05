import React, { useEffect, useState } from 'react';
import EventService from '../services/eventService';
import Betlist from './Betlist';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import { Label } from 'semantic-ui-react';



export default function SoccerEventList() {
  const [events, setEvents] = useState([]);
  const [open, setOpen] = React.useState(false);

  useEffect(() => {
    let eventService = new EventService();
    eventService.getEventsByCategory("Soccer").then(result => setEvents(result.data));
  }, []);
  return (
    <div>
      <TableContainer component={Paper}>
        <Table aria-label="collapsible table">
          <TableHead>
            <TableRow>
              <TableCell />
              <TableCell><Label style={{ color: 'green' }}>Start Time</Label></TableCell>
              <TableCell><Label style={{ color: 'green' }}>Final Time</Label></TableCell>
              <TableCell><Label style={{ color: 'green' }}>Category</Label></TableCell>
              <TableCell><Label style={{ color: 'green' }}>Country</Label></TableCell>
              <TableCell><Label style={{ color: 'brown' }}>Home</Label></TableCell>
              <TableCell><Label style={{ color: 'green' }}>Away</Label></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {events.map(event => (
              <React.Fragment key={event.event_id}>
                <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
                  <TableCell>
                    <IconButton
                      aria-label="expand row"
                      size="small"
                      onClick={() => setOpen(!open)}
                    >
                      {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
                    </IconButton>
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {event.start_time.slice(0,16)}
                  </TableCell>
                  <TableCell >{event.final_time.slice(0,16)}</TableCell>
                  <TableCell style={{ color: 'green' }}>{event.sport_category}</TableCell>
                  <TableCell>{event.country}</TableCell>
                  <TableCell style={{ color: 'brown' }}>{event.home}</TableCell>
                  <TableCell>{event.away}</TableCell>
                </TableRow>
                {<Betlist open ={open} event_id={event.event_id}/>}
              </React.Fragment>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

