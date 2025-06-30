import { useState } from "react"

import axios from 'axios'
import { useNavigate } from "react-router-dom"
function Register(){
    const nav=useNavigate();
    const [form,setform]=useState(
        {
            username:"",
            email:"",
            password:""
        }
    )
    const change=(e) =>
    {
        setform({...form,[e.target.name]:e.target.value})
    }
    const submit=async (e)=>
    {
        try{
        e.preventDefault()
       const result=await axios.post('http://localhost:8082/api/user/register',form)
       console.log(result.data);
       console.log(result.status)
       alert(result.data)
       nav('/login')
        }
        catch(err){
            alert(err.response.data);
        }
    }
    return(
        <>
        <h1> Welcome to Registration page</h1>
        {/* <p>Name:{form.username}</p>
        <p>Email:{form.email}</p> 
        <p>Password:{form.password}</p> */}
        <form onSubmit={submit}>
            <input onChange={change} type="text" name="username" placeholder="Create your username name.."/><br/>
            <input onChange={change} type="email" name="email" placeholder="Enter your email.."/><br/>
            <input onChange={change} type="password" name="password" placeholder="Create password.."/><br/>
            <button type="submit">Register</button>
        </form>
        </>
    )
}
export default Register