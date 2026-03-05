import React from 'react'
import Button from '../Component/Button'
import { useNavigate } from 'react-router-dom'
import CardComponent from '../Component/CardComponent.jsx'

const Home = () => {

  const navigate=useNavigate();
  return (
    <div className="min-h-screen flex flex-col items-center justify-center  ">
        <h1 className="text-4xl font-bold mb-3" >CampusPulse</h1>
        <p className="mb-6">Discover. Register. Participate.</p>
        <Button onClick={()=>{
          navigate("/events")
        }}/>
    
      

    </div>
  )
}

export default Home