import React from 'react';
import MovieList from './MovieList';
import ActorList from "./ActorList";
import DirectorList from "./DirectorList";
import NewMovieForm from "./NewMovieForm";

const App = () => {
  return (
      <div>
          <h1>KINO</h1>
        <MovieList />
        <ActorList />
          <DirectorList/>
          <NewMovieForm/>
          {/* komentarz */}
      </div>
  );
};

export default App;
