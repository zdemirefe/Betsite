import { combineReducers } from "redux";
import cartReducer from "./reducers/cartReducer"
import customerReducer from "./reducers/customerReducer";

const rootReducer = combineReducers({
    cart:cartReducer,
    customer:customerReducer
})
export default rootReducer