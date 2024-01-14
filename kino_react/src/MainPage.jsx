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
import MovieSeance from "./MovieSeance";
const MainPage = ({ children }) => {

    return (
        <div>
            <MovieSeance/>
        </div>
    );
};

export default MainPage;