import React, {useState, useEffect, useCallback} from "react";
//import './App.css';
import axios from "axios";
import {useDropzone} from "react-dropzone";

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
                <UnDropzone />
                <h2>{userProf.username}</h2>
                <h4>{userProf.profileId}</h4>
            </div>
        );
    });

    function UnDropzone(){
        const onDrop = useCallback( files => {
            // todo handle files
        }, []);

        const {getRootProps, getInputProps, isDragActive} = useDropzone({ onDrop });

        return (
            <div { ...getRootProps() }>
                <input  { ...getInputProps() } />
                { isDragActive ?
                 ( <p>- drop the file -</p> )
                 :
                 ( <p>= drag and drop =</p> )

                 }
            </div>
        )
    }

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
