package org.example.view;

import org.example.DAL.Models.Album;
import org.example.controllers.*;
import org.example.util.JsonConverter;

import java.util.List;
import java.util.Scanner;

public class Navigation implements View {
    private Scanner input = new Scanner(System.in);
    private final AlbumController albumController = new AlbumController();
    private final ArtistController artistController = new ArtistController();
    private final GenreController genreController = new GenreController();
    private final LabelController labelController = new LabelController();
    private final PlaylistController playlistController = new PlaylistController();
    private final RadioDjController radioDjController = new RadioDjController();
    private final RadioProgramController radioProgramController = new RadioProgramController();
    private final SongController songController = new SongController();
    private final DBUserController userController = new DBUserController();

    @Override
    public void displayLoginPage() {
        boolean show = true;
        String email = "";
        String password = "";

        while(show){
            System.out.println("----------------------------");
            System.out.println("Enter login and password: ");

            String[] loginAndPass = input.nextLine().split(" ");

            boolean result = userController.checkLogin(loginAndPass[0], loginAndPass[1]);

            if (result){
                System.out.println("Successful login.");
                break;
            }
            else
                System.out.println("Error: Wrong login or password.");
        }

        displayMenuPage();
    }

    @Override
    public void displayMenuPage() {
        boolean show = true;

        while (show) {
            System.out.println("----------------------------");
            System.out.println("Choose a table to work with:");
            System.out.println("1. Albums");
            System.out.println("2. Artists");
            System.out.println("3. Songs");
            System.out.println("4. Playlists");
            System.out.println("5. Genres");
            System.out.println("6. Labels");
            System.out.println("7. Radio programs");
            System.out.println("8. Radio Djs");
            System.out.println("0. Exit");
            System.out.println("----------------------------");

            int option = Integer.parseInt(input.nextLine());

            switch (option) {
                case (1):
                    displayAlbumPage();
                    break;
                case (2):
                    displayArtistPage();
                    break;
                case (3):
                    displaySongPage();
                    break;
                case (4):
                    displayPlaylistPage();
                    break;
                case (5):
                    displayGenrePage();
                    break;
                case (6):
                    displayLabelPage();
                    break;
                case (7):
                    displayRadioProgramPage();
                    break;
                case (8):
                    displayRadioDjPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    System.out.println("You should choose a table.");
                    break;
            }
        }
    }

    @Override
    public void displayAlbumPage() {
        boolean show = true;

        while (show) {
            System.out.println("   <----------------------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all albums");
            System.out.println("    2. Show album by id");
            System.out.println("    3. Add album");
            System.out.println("    4. Delete album");
            System.out.println("    5. Edit album");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option = Integer.parseInt(input.nextLine());
            switch (option) {
                case (1):
                    displayAllAlbumsPage();
                    break;
                case (2):
                    displayAlbumByIdPage();
                    break;
                case (3):
                    displayAddAlbumPage();
                    break;
                case (4):
                    displayDeleteAlbumPage();
                    break;
                case (5):
                    displayEditAlbumPage();
                    break;
                case (0):
                    show = false;
                    break;
            }
        }
    }
    @Override
    public void displayArtistPage () {

    }

    @Override
    public void displayGenrePage () {

    }

    @Override
    public void displayLabelPage () {

    }

    @Override
    public void displayPlaylistPage () {

    }

    @Override
    public void displayRadioDjPage () {

    }

    @Override
    public void displayRadioProgramPage () {

    }

    @Override
    public void displaySongPage () {

    }

    private void displayEditAlbumPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter ID of an album to edit.");

        Long id = Long.parseLong(input.nextLine());
        Album album = albumController.getAlbumById(id);

        if (album == null){
            System.out.println("Error: Unsuccessful. No album with such ID.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change album name");
            System.out.println("        2. Change genre");
            System.out.println("        3. Change artist by ID");
            System.out.println("        4. Change artist by name");
            System.out.println("        5. Change number of tracks");
            System.out.println("        6. Back to album menu");

            int option = Integer.parseInt(input.nextLine());
            switch (option){
                case(1):
                    displayChangeAlbumNamePage(id);
                    break;
                case(2):
                    displayChangeAlbumGenrePage(id);
                    break;
                case(3):
                    displayChangeAlbumArtistIdPage(id);
                    break;
                case(4):
                    displayChangeAlbumArtistNamePage(id);
                    break;
                case(5):
                    displayChangeAlbNumOfTracksPage(id);
                    break;
                case(6):
                    show = false;
                    break;
            }
        }
    }

    private void displayChangeAlbNumOfTracksPage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new number of tracks:");

        Integer newNumOfTracks = Integer.parseInt(input.nextLine());
        albumController.updateNumberOfTracks(id, newNumOfTracks);
        System.out.println("Album update successful.");
    }

    private void displayChangeAlbumArtistIdPage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new artist ID:");

        Long artistId = Long.parseLong(input.nextLine());
        albumController.updateAlbumArtist(id, artistId);
        System.out.println("Album update successful.");
    }

    private void displayChangeAlbumArtistNamePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new artist name:");

        String artistName = input.nextLine();
        albumController.updateAlbumArtist(id, artistName);
        System.out.println("Album update successful.");
    }

    private void displayChangeAlbumGenrePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new genre code:");

        Long genreCode = Long.parseLong(input.nextLine());
        albumController.updateAlbumGenre(id, genreCode);
        System.out.println("Album update successful.");
    }

    private void displayChangeAlbumNamePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the album:");

        String newAlbumName = input.nextLine();
        albumController.updateAlbumName(id, newAlbumName);
        System.out.println("Album update successful.");
    }

    private void displayDeleteAlbumPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter ID of an album to delete.");

        Long id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result = false;

        while(show){
            System.out.println("Are you sure you want to delete the album? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = albumController.deleteAlbum(id);
                    if (result)
                        System.out.println("Album successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid ID.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddAlbumPage() {
        String albumName;
        Long genreCode;
        Long artistId;
        int numberOfTracks;
        Long labelId;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter album name:");
        albumName = input.nextLine();

        System.out.println("2. Enter genre code:");
        genreCode = Long.parseLong(input.nextLine());

        System.out.println("3. Enter artist id:");
        artistId = Long.parseLong(input.nextLine());

        System.out.println("4. Enter number of tracks:");
        numberOfTracks = Integer.parseInt(input.nextLine());

        System.out.println("5. Enter label id:");
        labelId = Long.parseLong(input.nextLine());

        boolean result = albumController.addAlbum(albumName, genreCode, artistId, numberOfTracks, labelId);

        if (result == false)
            System.out.println("Error: Unsuccessful. Invalid data.");
        else
            System.out.println("Album added successfully.");
    }

    private void displayAlbumByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id: ");

        Long id = Long.parseLong(input.nextLine());
        Album album = albumController.getAlbumById(id);

        if (album != null)
            System.out.println(JsonConverter.getConvertedToJson(album));
        else
            System.out.println("No album with such ID.");
    }

    private void displayAllAlbumsPage() {
        System.out.println("--------------------------------");
        System.out.println("All albums:");
        List<Album> albums = albumController.getAllAlbums();
        System.out.println(JsonConverter.getConvertedToJson(albums));
    }
}
