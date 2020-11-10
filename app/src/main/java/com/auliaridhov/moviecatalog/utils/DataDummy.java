package com.auliaridhov.moviecatalog.utils;

import com.auliaridhov.moviecatalog.data.MoviesEntity;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {
    public static List<MoviesEntity> generateDummyMovies() {
        ArrayList<MoviesEntity> movies = new ArrayList<>();
        movies.add(new MoviesEntity("12",
                "https://image.tmdb.org/t/p/w500/8h0CG12Oft1GqthLmsctg8iuQQj.jpg",
                "Finding Nemo",
                "Nemo, an adventurous young clownfish, is unexpectedly taken from his Great Barrier Reef home to a dentist's office aquarium. It's up to his worrisome father Marlin and a friendly but forgetful fish Dory to bring Nemo home -- meeting vegetarian sharks, surfer dude turtles, hypnotic jellyfish, hungry seagulls, and more along the way.",
                "44.241",
                "2003-05-30"));
        movies.add(new MoviesEntity("1771",
                "https://image.tmdb.org/t/p/w500/2tOgiY533JSFp7OrVlkeRJvsZpI.jpg",
                "Captain America: The First Avenger",
                "During World War II, Steve Rogers is a sickly man from Brooklyn who's transformed into super-soldier Captain America to aid in the war effort. Rogers must stop the Red Skull – Adolf Hitler's ruthless head of weaponry, and the leader of an organization that intends to use a mysterious device of untold powers for world domination.",
                "65.567",
                "2016-04-27"));
        movies.add(new MoviesEntity("272",
                "https://image.tmdb.org/t/p/w500/1P3ZyEq02wcTMd3iE4ebtLvncvH.jpg",
                "Batman Begins",
                "Driven by tragedy, billionaire Bruce Wayne dedicates his life to uncovering and defeating the corruption that plagues his home, Gotham City.  Unable to work within the system, he instead creates a new identity, a symbol of fear for the criminal underworld - The Batman.",
                "48.229",
                "2005-06-10"));
        movies.add(new MoviesEntity("131321",
                "https://image.tmdb.org/t/p/w500/gfJGlDaHuWimErCr5Ql0I8x9QSy.jpg",
                "Wonder Woman",
                "An Amazon princess comes to the world of Man in the grips of the First World War to confront the forces of evil and bring an end to human conflict.",
                "72.788",
                "2017-05-30"));
        movies.add(new MoviesEntity("5124",
                "https://image.tmdb.org/t/p/w500/cUXmPG5Dm3XdAeUjucL93KrtkAY.jpg",
                "Sinister",
                "Found footage helps a true-crime novelist realize how and why a family was murdered in his new home, though his discoveries put his entire family in the path of a supernatural entity.",
                "57.205",
                "2012-03-29"));
        movies.add(new MoviesEntity("284053",
                "https://image.tmdb.org/t/p/w500/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg",
                "Thor: Ragnarok",
                "Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the destruction of his home-world and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.",
                "99.511",
                "2017-10-25"));
        return movies;
    }

    public static List<MoviesEntity> generateDummyTvShow() {
        ArrayList<MoviesEntity> tvShow = new ArrayList<>();
        tvShow.add(new MoviesEntity("152",
                "https://image.tmdb.org/t/p/w500/gHUCCMy1vvj58tzE3dZqeC9SXus.jpg",
                "Marvel's Agents of S.H.I.E.L.D.: Slingshot",
                "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.",
                "125.134",
                "2013-09-24"));
        tvShow.add(new MoviesEntity("412",
                "https://image.tmdb.org/t/p/w500/3EDyt08lgg26WhW7nQE4r7YL3ul.jpg",
                "WWF Wrestling Challenge",
                "WWF Wrestling Challenge was a professional wrestling television program produced by the World Wrestling Federation. It was syndicated weekly and aired from 1986 to 1995. The show became simply known as WWF Challenge in 1995. The show featured matches, pre-match interviews, and occasionally, summarized weekly events in WWF programming. Matches primarily saw top tier and mid-level talent versus jobbers. At times, there was a \\\"feature\\\" match between main WWF talent. As with other syndicated WWF programming, the show promoted WWF event dates and house shows in local media markets.",
                "4.151",
                "1986-09-07"));
        tvShow.add(new MoviesEntity("32542",
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "695.587",
                "2017-09-25"));
        tvShow.add(new MoviesEntity("3636",
                "https://image.tmdb.org/t/p/w500/rFdzPaFdfm3LZ9lBYtiM08MT0n1.jpg",
                "Hey Arnold!",
                "The daily life of Arnold--a fourth-grader with a wild imagination, street smarts and a head shaped like a football.",
                "30.554",
                "1996-10-07"));
        tvShow.add(new MoviesEntity("373",
                "https://image.tmdb.org/t/p/w500/xpm5ypAg0FySsHVW0smOTgQbhF.jpg",
                "Cat vs. Dog",
                "Pets fighting like cats and dogs, unable to live under the same roof, can tear otherwise peaceful homes into turbulent messes. Enter cat behaviorist Jackson Galaxy and dog trainer Zoe Sandor, who assist families seeking peace between ill-behaved kitties and pooches. After meeting with families, Jackson and Zoe address the behaviors of both humans and animals, then they create long-term plans featuring daily routines and procedures, with the goal of conflict resolution to create homes where cats and dogs can coexist.",
                "0.6",
                "2017-11-11"));
        return tvShow;
    }
}
