import React, {useState} from 'react';
import MovieList from "./MovieList";
import NewMovieForm from "./NewMovieForm";
import ActorList from "./ActorList";
import NewActorForm from "./NewActorForm";
import DirectorList from "./DirectorList";
import NewDirectorForm from "./NewDirectorForm";
import HallList from "./HallList";
import NewHallForm from "./NewHallForm";
import SeanceList from "./SeanceList";
import NewSeanceForm from "./NewSeanceForm";


const AdminPanel = ({ children }) => {

    const[showAddNewMovieForm, setShowAddNewMovieForm] = useState(false);
    const[showAddNewActorForm, setShowAddNewActorForm] = useState(false);
    const[showAddNewDirectorForm, setshowAddNewDirectorForm] = useState(false);
    const[showAddNewHallForm, setshowAddNewHallForm] = useState(false);
    const[showAddNewSeanceForm, setshowAddNewSeanceForm] = useState(false);

    const style = {
        backgroundColor: 'lightblue',
        padding: '20px',
    };

    return (
        <div className="container d-flex justify-content-center" style={style}>
            <div className="my-5 p-4 border border-primary text-center">
                <h1 className="display-4">KINO</h1>
                <div>
                    <MovieList />

                    <button className='btn btn-primary mt-5' onClick={() => setShowAddNewMovieForm(!showAddNewMovieForm)}>
                        {showAddNewMovieForm ? "ZWIN FORMULARZ" : "ROZWIN FORMULARZ DODAWANIA FILMU"}
                    </button>
                    {showAddNewMovieForm &&
                        <NewMovieForm/>
                    }
                </div>

                <div>
                    <ActorList />

                    <button className='btn btn-primary mt-5' onClick={() => setShowAddNewActorForm(!showAddNewActorForm)}>
                        {showAddNewMovieForm ? "ZWIN FORMULARZ" : "ROZWIN FORMULARZ DODAWANIA AKTORA"}
                    </button>

                    {showAddNewActorForm &&
                        <NewActorForm/>
                    }
                </div>

                <div>
                    <DirectorList/>

                    <button className='btn btn-primary mt-5' onClick={() => setshowAddNewDirectorForm(!showAddNewDirectorForm)}>
                        {showAddNewDirectorForm ? "ZWIN FORMULARZ" : "ROZWIN FORMULARZ DODAWANIA REZYSERA"}
                    </button>

                    {showAddNewDirectorForm &&
                        <NewDirectorForm/>
                    }

                </div>

                <div >
                    <HallList />

                    <button className='btn btn-primary mt-5' onClick={() => setshowAddNewHallForm(!showAddNewHallForm)}>
                        {showAddNewHallForm ? "ZWIN FORMULARZ" : "ROZWIN FORMULARZ DODAWANIA SALI"}
                    </button>
                    {showAddNewHallForm &&
                        <NewHallForm/>
                    }
                </div>

                <div>
                    <SeanceList />

                    <button className='btn btn-primary mt-5' onClick={() => setshowAddNewSeanceForm(!showAddNewSeanceForm)}>
                        {showAddNewSeanceForm ? "ZWIN FORMULARZ" : "ROZWIN FORMULARZ DODAWANIA AKTORA"}
                    </button>

                    {showAddNewSeanceForm &&
                        <NewSeanceForm/>
                    }
                </div>
                {/* komentarz */}
            </div>
        </div>
    );
};

export default AdminPanel;