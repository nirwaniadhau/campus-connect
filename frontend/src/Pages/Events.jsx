import React from 'react'
import { useState,useEffect } from 'react'
import Button from '../Component/Button'
import CardComponent from '../Component/CardComponent.jsx'

const Events = () => {
    const [events,SetEvents]=useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/events/getAllevents")
        .then(response=>response.json())
        .then(data=>SetEvents(data))
        .catch(error=>console.error(error))
    },[]);

  return (
    <div className="grid grid-cols-3 gap-6">
        {events.map(event=>(
             <CardComponent key={event.id} event={event} />
            
        ))}
    </div>
  )
}

export default Events