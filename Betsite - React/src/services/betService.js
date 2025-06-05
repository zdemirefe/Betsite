import axios from "axios";

export default class BetService 
{
    getBetsByEventId(event_id)
    {
        return axios.get(`http://localhost:8080/api/bets/getbyeventid?event_id=${event_id}`)
    }
    getBets(){
        return axios.get("http://localhost:8080/api/bets/allbets")
    }
}