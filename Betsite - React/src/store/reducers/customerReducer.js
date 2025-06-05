import { LOGIN, LOGOUT } from "../actions/customerActions";


const initialState=[]
export default function customerReducer(state = initialState,{type,payload,isAuth}) {
    switch (type) {
        case LOGIN:
            state=[payload,isAuth]
            return state
        case LOGOUT:
            state=[payload,isAuth]          
            return state
        default:
            return state
    }
}