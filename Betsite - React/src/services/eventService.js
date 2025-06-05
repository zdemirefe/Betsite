import axios from "axios";

export default class EventService 
{
    getEvents()
    {
        return axios.get("http://localhost:8080/api/events/getAll")
    }

    getEventsByCategory(category)
    {
        return axios.get(`http://localhost:8080/api/events/getByCategory?category=${category}`)
    }
}