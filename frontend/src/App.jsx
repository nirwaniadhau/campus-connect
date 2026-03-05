import { BrowserRouter,Routes,Route } from "react-router-dom"
import Home from "./Pages/Home"
import Events from "./Pages/Events"
function App() {
  return(
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>}></Route>
      <Route path="/events" element={<Events/>}></Route>
    </Routes>
    </BrowserRouter>
  )
}

export default App
