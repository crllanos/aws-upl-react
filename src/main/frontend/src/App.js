import React, {useState, useEffect, useCallback} from "react";
//import './App.css';
import axios from "axios";
import {useDropzone} from "react-dropzone";

const UserProfiles = () => {

    const [userProfiles, setUserProfiles] = useState([]);
    const apiUserProfile = "http://localhost:8080/api/v1/user-profile";

    const fetchUserProfiles = () => {
        axios.get(apiUserProfile)
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
            <div className="fisha" key={idx}>
                {/** todo cargar imagen profile */}
                <h2>{userProf.username}</h2>
                <h4>{userProf.profileId}</h4>
                <UnDropzone {...userProf} />
            </div>
        );
    });

    function UnDropzone({ profileId }){
        const onDrop = useCallback( files => {
            const file = files[0];
            console.log(file);

            const formData = new FormData();
            formData.append("file", file);
            axios.post(`${apiUserProfile}/${profileId}/image/upload`, formData,
                {
                    headers: { "Content-type" : "multipart/form-data" }
                }
            )
            .then(() => { console.log("upload ok"); })
            .catch(e => { console.error(e); });
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
