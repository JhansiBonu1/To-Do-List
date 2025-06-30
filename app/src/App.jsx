
import Login from './components/Login'
import Register from './components/Register'
import Home from './components/Home'
import TaskManager from './components/TaskManager';
import './app.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
function App()
{
  return(
    <>
     <BrowserRouter>
     <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/register" element={<Register/>}/>
      <Route path="/login" element={<Login/>}/>
      <Route path="/taskmanager" element={<TaskManager/>}/>
     </Routes>
     </BrowserRouter>
    </>
  )
}
export default App