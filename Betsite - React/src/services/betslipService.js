import axios from "axios";


export default class BetslipService {

    getBetslipCustomerId(id) {
        return axios.get(`http://localhost:8080/api/betslip/mybetslips/customerId?customer_id=${id}`)
    }

    postBetslip(betslip) {
        return axios.post('http://localhost:8080/api/betslip/createbetslip',betslip)
    }
}