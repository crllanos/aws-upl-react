import React, {useState, useEffect} from "react";
//import './App.css';
import axios from "axios";

const UserProfiles = () => {

    const [userProfiles, setUserProfiles] = useState([]);

    const fetchUserProfiles = () => {
        axios.get("http://localhost:8080/api/v1/user-profile")
             .then(rsp => {
                const data = rsp.data;
                console.log(data);
                setUserProfiles(data);
             });
    };

    useEffect(() => {
        fetchUserProfiles();
    }, []);

    return userProfiles.map((userProf, idx) => {
        return (
            <div key={idx}>
                <h2>{userProf.username}</h2>
                <h4>{userProf.profileId}</h4>
            </div>
        );
    });
};

function App() {
  return (
    <div className="App">
    <h1>oa!!</h1>
    <UserProfiles />
    </div>
  );
}

export default App;
