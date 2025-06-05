import axios from "axios";

export default class CustomerService {

    getCustomers() {
        return axios.get("http://localhost:8080/api/customers/getAll")
    }
    postCustomer(customer) {
        console.log(customer)
        return axios.post("http://localhost:8080/api/customers/post", customer)
    }
    updateCustomer(customer) {
        return axios.post(`http://localhost:8080/api/customers/update`, customer)
    }
}