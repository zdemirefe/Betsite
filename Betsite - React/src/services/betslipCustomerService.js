import axios from "axios";


export default class BetslipCustomerService {

    getBetslipCustomer(){
        return axios.get("http://localhost:8080/api/betslipcustomer/getAll")
    }
    postBetslipCustomer(betslipCustomer){
        return axios.post("http://localhost:8080/api/betslipcustomer/postAll",betslipCustomer)
    }
}