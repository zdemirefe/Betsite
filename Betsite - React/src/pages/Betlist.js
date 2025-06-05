import React, { useEffect, useState } from 'react'
import BetService from '../services/betService'
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import { useDispatch } from 'react-redux';
import { Button, Label } from 'semantic-ui-react';
import { addToCart } from '../store/actions/cartActions';
import {toast} from "react-toastify"
import 'react-toastify/dist/ReactToastify.css';


export default function Betlist(props) {
  const [bets, setBets] = useState([])
  const dispatch = useDispatch()
  useEffect(() => {
    let betService = new BetService()
    betService.getBetsByEventId(props.event_id).then(result => setBets(result.data))
  }, [props.event_id])
  
  const handleToCart = (bet) => {
    console.log("Clicked - Bet:", bet);
    dispatch(addToCart(bet))
    toast(`${bet.bet_type+"  "+bet.bet_ratio} Added to Betslip`);
  };
  
  

  return (
    
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={props.open} timeout="auto" unmountOnExit>
            <Box sx={{ margin: 1 }}>
              <Typography variant="h6" gutterBottom component="div">
                <Label color='blue'>BETS</Label>
              </Typography>
              <Table size="small" aria-label="purchases">
                <TableHead>
                  <TableRow>
                    <TableCell style={{ color: 'green' }}>Bet Type</TableCell>
                    <TableCell style={{ color: 'green' }}>Bet Ratio</TableCell>
                    <TableCell></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {bets.map((bet) => (
                    <TableRow key={bet.bet_id}>
                      <TableCell component="th" scope="row">
                        {bet.bet_type}
                      </TableCell>
                      <TableCell>{bet.bet_ratio}</TableCell>
                      <TableCell><Button color='blue' onClick={()=>handleToCart(bet)}> Add to MyBetslip</Button></TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>

  )
}
