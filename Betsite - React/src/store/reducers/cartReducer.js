import { ADD_TO_CART, REMOVE_FROM_CART } from "../actions/cartActions";
import { cartItems } from "../initialValues/cartItems"


const initialState = {
    cartItems: cartItems
}

export default function cartReducer(state = initialState, { type, payload }) {
    switch (type) {
        case ADD_TO_CART: 
        let handleCart = false
            state.cartItems.map((item)=>{
                console.log(item)
                if(item.bet.event_id===payload.event_id)
                {handleCart=true}
            })
            if (handleCart) {
                return {
                    ...state
                };
            } else {
                return {
                    ...state,
                    cartItems: [...state.cartItems, {bet: payload }]
                };
            }
        case REMOVE_FROM_CART: 
            return {
                ...state,
                cartItems: state.cartItems.filter((c) => c.bet.bet_id !== payload.bet_id)
            };
        default: 
            return state;
            
    }
}
