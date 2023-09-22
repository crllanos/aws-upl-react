import React, {useState, useEffect} from "react";
import './App.css';
import axios from "axios";

const UserProfiles = () => {
    console.log("llega aca");

    const fetchUserProfiles = () => {
        axios.get("http://localhost:8080/api/v1/user-profile")
             .then(rsp => {
                console.log(rsp);
             });
    };

    useEffect(() => {
        fetchUserProfiles();
    }, []);

    return <h1>UserProf!</h1>;
}

function App() {
  return (
    <div className="App">
    <h1>oa!!</h1>
    <UserProfiles />
    </div>
  );
}

export default App;
