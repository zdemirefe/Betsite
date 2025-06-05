export const ADD_TO_CART = "ADD_TO_CART"
export const REMOVE_FROM_CART = "REMOVE_FROM_CART"


export function addToCart(bet) {
    return {
        type: ADD_TO_CART,
        payload:bet,
    }
}

export function remoweFromCart(bet) {
    return {
        type: REMOVE_FROM_CART,
        payload:bet,
    }
}