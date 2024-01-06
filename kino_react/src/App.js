import React, {useState} from 'react';
import MovieList from './MovieList';
import ActorList from "./ActorList";
import DirectorList from "./DirectorList";
import NewMovieForm from "./NewMovieForm";
import NewActorForm from "./NewActorForm";
import NewDirectorForm from "./NewDirectorForm";

const App = () => {

    const[showAddNewMovieForm, setShowAddNewMovieForm] = useState(false);
    const[showAddNewActorForm, setShowAddNewActorForm] = useState(false);
    const[showAddNewDirectorForm, setshowAddNewDirectorForm] = useState(false);


  return (
      <div>
          <h1>KINO</h1>
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
          {/* komentarz */}
      </div>
  );
};

export default App;
