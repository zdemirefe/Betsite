export const LOGIN ="LOGIN"
export const LOGOUT="LOGOUT"
export const isAuth=false

export function logIn(customer,isAuth) {
    return {
        type: LOGIN,
        payload:customer,
        isAuth:isAuth
    }
}

export function logOut(customer,isAuth) {
    return {
        type: LOGOUT,
        payload:customer,
        isAuth:isAuth
    }
}