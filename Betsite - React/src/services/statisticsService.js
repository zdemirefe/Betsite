import axios from "axios";

export default class StatisticsService 
{

    getStatisticsByUser(id){
        return axios.get(`http://localhost:8080/api/statistics/customerid?customer_id=${id}`)
    }


}