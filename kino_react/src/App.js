import React, {useState} from 'react';
import MovieList from './MovieList';
import ActorList from "./ActorList";
import DirectorList from "./DirectorList";
import NewMovieForm from "./NewMovieForm";

const App = () => {

    const[showAddNewMovieForm, setShowAddNewMovieForm] = useState(false);


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
          <ActorList />
          <DirectorList/>

          {/* komentarz */}
      </div>
  );
};

export default App;
