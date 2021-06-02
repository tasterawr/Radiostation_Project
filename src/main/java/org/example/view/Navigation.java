package org.example.view;

import org.example.DAL.Models.*;
import org.example.services.*;
import org.example.util.JsonConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navigation implements View {
    private final Scanner input = new Scanner(System.in);
    private final AlbumService albumService = new AlbumService();
    private final ArtistService artistService = new ArtistService();
    private final GenreService genreService = new GenreService();
    private final LabelService labelService = new LabelService();
    private final PlaylistService playlistService = new PlaylistService();
    private final RadioDjService radioDjService = new RadioDjService();
    private final RadioProgramService radioProgramService = new RadioProgramService();
    private final SongService songService = new SongService();
    private final DBUserService dbUserService = new DBUserService();

    //<editor-fold desc="Pages display section">

    @Override
    public void displayLoginPage() {
        while(true){
            System.out.println("----------------------------");
            System.out.println("Enter login and password: ");

            String[] loginAndPass = input.nextLine().split(" ");

            boolean result = dbUserService.checkLogin(loginAndPass[0], loginAndPass[1]);

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
            System.out.println("[MAIN MENU]-----------------");
            System.out.println("Choose a table to work with:");
            System.out.println("1. Albums");
            System.out.println("2. Artists");
            System.out.println("3. Songs");
            System.out.println("4. Playlists");
            System.out.println("5. Genres");
            System.out.println("6. Labels");
            System.out.println("7. Radio programs");
            System.out.println("8. Radio Djs");
            System.out.println("9. User Info");
            System.out.println("0. Exit");
            System.out.println("----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

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
                case (9):
                    displayLoginToUserPage();
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

    private void displayLoginToUserPage() {
        String[] loginAndPass;

        while(true){
            System.out.println("----------------------------");
            System.out.println("Access to this page is secured.");
            System.out.println("Enter login and password (or 'return' to go back to menu): ");

            String str = input.nextLine();

            if (str.equals("return")){
                return;
            }

            if (str.split(" ").length == 1){
                continue;
            }

            loginAndPass = str.split(" ");

            boolean result = dbUserService.checkLogin(loginAndPass[0], loginAndPass[1]);

            if (result){
                System.out.println("Successful login.");
                break;
            }
            else
                System.out.println("Error: Wrong login or password.");
        }

        displayUserPage(loginAndPass[0], loginAndPass[1]);
    }

    @Override
    public void displayAlbumPage() {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[ALBUM PAGE]-----------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all albums");
            System.out.println("    2. Show album by id");
            System.out.println("    3. Add album");
            System.out.println("    4. Delete album");
            System.out.println("    5. Edit album");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

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
                default:
                    break;
            }
        }
    }

    @Override
    public void displayArtistPage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[ARTIST PAGE]----------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all artists");
            System.out.println("    2. Show artist by id");
            System.out.println("    3. Show artist by name");
            System.out.println("    4. Add artist");
            System.out.println("    5. Delete artist by id");
            System.out.println("    6. Delete artist by name");
            System.out.println("    7. Edit artist");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllArtistsPage();
                    break;
                case (2):
                    displayArtistByIdPage();
                    break;
                case(3):
                    displayArtistByNamePage();
                    break;
                case (4):
                    displayAddArtistPage();
                    break;
                case (5):
                    displayDeleteArtistByIdPage();
                    break;
                case (6):
                    displayDeleteArtistByNamePage();
                    break;
                case(7):
                    displayEditArtistPage();
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayGenrePage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[GENRE PAGE]-----------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all genres");
            System.out.println("    2. Show genre by id");
            System.out.println("    3. Add genre");
            System.out.println("    4. Delete genre by id");
            System.out.println("    5. Delete genre by name");
            System.out.println("    6. Edit genre");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");


            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllGenresPage();
                    break;
                case (2):
                    displayGenreByCodePage();
                    break;
                case (3):
                    displayAddGenrePage();
                    break;
                case (4):
                    displayDeleteGenreByIdPage();
                    break;
                case (5):
                    displayDeleteGenreByNamePage();
                    break;
                case(6):
                    displayEditGenrePage();
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayLabelPage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[LABEL PAGE]-----------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all labels");
            System.out.println("    2. Show label by id");
            System.out.println("    3. Add label");
            System.out.println("    4. Delete label by id");
            System.out.println("    5. Edit label");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllLabelsPage();
                    break;
                case (2):
                    displayLabelByIdPage();
                    break;
                case (3):
                    displayAddLabelPage();
                    break;
                case (4):
                    displayDeleteLabelByIdPage();
                    break;
                case(5):
                    displayEditLabelPage();
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayPlaylistPage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[PLAYLIST PAGE]--------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all playlists");
            System.out.println("    2. Show playlist songs");
            System.out.println("    3. Show playlist by id");
            System.out.println("    4. Show playlist by name");
            System.out.println("    5. Add playlist");
            System.out.println("    6. Delete playlist by id");
            System.out.println("    7. Delete playlist by name");
            System.out.println("    8. Edit playlist");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllPlaylistsPage();
                    break;
                case (2):
                    displayPlaylistSongsPage();
                    break;
                case (3):
                    displayPlaylistByIdPage();
                    break;
                case (4):
                    displayPlaylistByNamePage();
                    break;
                case (5):
                    displayAddPlaylistPage();
                    break;
                case (6):
                    displayDeletePlaylistByIdPage();
                    break;
                case (7):
                    displayDeletePlaylistByNamePage();
                    break;
                case(8):
                    displayEditPlaylistPage();
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayRadioDjPage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[RADIO DJ PAGE]--------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all djs");
            System.out.println("    2. Show dj by id");
            System.out.println("    3. Add dj");
            System.out.println("    4. Delete dj by id");
            System.out.println("    5. Edit dj");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllDjsPage();
                    break;
                case (2):
                    displayDjByIdPage();
                    break;
                case (3):
                    displayAddDjPage();
                    break;
                case (4):
                    displayDeleteDjByIdPage();
                    break;
                case(5):
                    displayEditDjPage();
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayRadioProgramPage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[RADIO PROGRAM PAGE]---");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all radio programs");
            System.out.println("    2. Show radio program by id");
            System.out.println("    3. Show radio program by name");
            System.out.println("    4. Show radio program playlists");
            System.out.println("    5. Add radio program");
            System.out.println("    6. Delete radio program by id");
            System.out.println("    7. Delete radio program by name");
            System.out.println("    8. Edit radio program");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllRadioProgramsPage();
                    break;
                case (2):
                    displayRadioProgramByIdPage();
                    break;
                case (3):
                    displayRadioProgramByNamePage();
                    break;
                case (4):
                    displayProgramPlaylistsPage();
                    break;
                case (5):
                    displayAddRadioProgramPage();
                    break;
                case(6):
                    displayDeleteRadioProgramByIdPage();
                    break;
                case(7):
                    displayDeleteRadioProgramByNamePage();
                    break;
                case(8):
                    displayEditRadioProgramPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displaySongPage () {
        boolean show = true;

        while (show) {
            System.out.println("   <-----[SONG PAGE]------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all songs");
            System.out.println("    2. Show label by id");
            System.out.println("    3. Add song");
            System.out.println("    4. Delete song by id");
            System.out.println("    5. Edit song");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option) {
                case (1):
                    displayAllSongsPage();
                    break;
                case (2):
                    displaySongByIdPage();
                    break;
                case (3):
                    displayAddSongPage();
                    break;
                case (4):
                    displayDeleteSongByIdPage();
                    break;
                case(5):
                    displayEditSongPage();
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    //</editor-fold>

    //<editor-fold desc="User display section">

    private void displayUserPage(String login, String password) {
        boolean show = true;
        while(show){
            System.out.println("   <-----[USER PAGE]------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Change login");
            System.out.println("    2. Change password");
            System.out.println("    0. Main menu");
            System.out.println("   <----------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(NumberFormatException e){
                option = 100;
            }

            switch (option){
                case(1):
                    login = displayChangeLoginPage(login, password);
                    break;
                case(2):
                    password = displayChangePasswordPage(login, password);
                    break;
                case(0):
                    show = false;
                    break;
            }
        }
    }

    private String displayChangePasswordPage(String login, String password) {
        while(true){
            System.out.println("----------------------------");
            System.out.println("Enter new password:");
            String newPassword = input.nextLine();

            System.out.println("Enter new password again:");
            String newPasswordCheck = input.nextLine();

            if (newPassword.equals(newPasswordCheck)){
                dbUserService.setPassword(login, password, newPassword);
                System.out.println("Password update successful.");
                return newPassword;
            }
            else{
                System.out.println("Passwords don't match.");
            }
        }
    }

    private String displayChangeLoginPage(String login, String password) {
        System.out.println("----------------------------");
        System.out.println("Enter new login:");

        String newLogin = input.nextLine();

        dbUserService.setLogin(login, password, newLogin);
        System.out.println("Login update successful.");
        return newLogin;
    }

    //</editor-fold>

    //<editor-fold desc="Playlist display section">

    private void displayEditPlaylistPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a playlist to edit.");

        Long playlistId = Long.parseLong(input.nextLine());

        if (playlistService.getPlaylistById(playlistId) == null){
            System.out.println("Error: Unsuccessful. No playlist with such id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change playlist name");
            System.out.println("        2. Add song to the playlist");
            System.out.println("        3. Remove song from the playlist");
            System.out.println("        0. Back to playlist menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangePlaylistNamePage(playlistId);
                    break;
                case(2):
                    displayAddSongToPlaylistPage(playlistId);
                    break;
                case(3):
                    displayRemoveSongFromPlaylistPage(playlistId);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayRemoveSongFromPlaylistPage(Long playlistId) {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a song to delete:");

        Long songId = Long.parseLong(input.nextLine());
        boolean result = playlistService.removeSongFromPlaylist(playlistId, songId);

        if (result)
            System.out.println("Song was removed successfully.");
        else
            System.out.println("Error: Unsuccessful. Invalid song id.");
    }

    private void displayAddSongToPlaylistPage(Long playlistId) {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a song to add:");

        Long songId = Long.parseLong(input.nextLine());
        boolean result = playlistService.addSongToPlaylist(playlistId, songId);

        if (result)
            System.out.println("Song was added successfully.");
        else
            System.out.println("Error: Unsuccessful. Invalid song id.");
    }

    private void displayChangePlaylistNamePage(Long playlistId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the playlist:");

        String newPlaylistName = input.nextLine();
        boolean result = playlistService.updatePlaylistName(playlistId, newPlaylistName);

        if (result)
            System.out.println("Playlist update successful.");
        else
            System.out.println("Error: Unsuccessful. Playlist with such name already exists.");
    }

    private void displayDeletePlaylistByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter name of a playlist to delete:");

        String playlistName = input.nextLine();

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the playlist? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = playlistService.deletePlaylist(playlistName);
                    if (result)
                        System.out.println("Playlist successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid playlist name.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayDeletePlaylistByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a playlist to delete:");

        Long playlistId = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the playlist? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = playlistService.deletePlaylist(playlistId);
                    if (result)
                        System.out.println("Playlist successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid playlist id.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddPlaylistPage() {
        String playlistName;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter playlist name:");
        playlistName = input.nextLine();

        boolean result = playlistService.addPlaylist(playlistName);

        if (result)
            System.out.println("Playlist added successfully.");
        else
            System.out.println("Error: Unsuccessful. Playlist with such name already exists.");
    }

    private void displayPlaylistByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter playlist name: ");

        String playlistName = input.nextLine();
        Playlist playlist = playlistService.getPlaylistByName(playlistName);

        if (playlist != null)
            System.out.println(JsonConverter.getConvertedToJson(playlist));
        else
            System.out.println("No playlist with such name.");
    }

    private void displayPlaylistByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter playlist id: ");

        Long playlistId = Long.parseLong(input.nextLine());
        Playlist playlist = playlistService.getPlaylistById(playlistId);

        if (playlist != null)
            System.out.println(JsonConverter.getConvertedToJson(playlist));
        else
            System.out.println("No playlist with such ID.");
    }

    private void displayPlaylistSongsPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter playlist id: ");

        Long playlistId = Long.parseLong(input.nextLine());

        System.out.println("All songs:");

        List<Song> songs = new ArrayList<>(playlistService.getPlaylistSongs(playlistId));
        System.out.println(JsonConverter.getConvertedToJson(songs));
    }

    private void displayAllPlaylistsPage() {
        System.out.println("--------------------------------");
        System.out.println("All playlists:");
        List<Playlist> playlists = playlistService.getAllPlaylists();
        System.out.println(JsonConverter.getConvertedToJson(playlists));
    }

    //</editor-fold>

    //<editor-fold desc="RadioProgram display section">

    private void displayEditRadioProgramPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a radio program to edit.");

        Long radioProgramId = Long.parseLong(input.nextLine());

        if (radioProgramService.getProgramById(radioProgramId) == null){
            System.out.println("Error: Unsuccessful. No radio program with such id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change radio program name");
            System.out.println("        2. Change radio program monthly listeners");
            System.out.println("        3. Change radio program song order price");
            System.out.println("        4. Add playlist to a radio program");
            System.out.println("        5. Delete playlist from radio program");
            System.out.println("        0. Back to radio program menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangeRadioProgramNamePage(radioProgramId);
                    break;
                case(2):
                    displayChangeRadioProgMonthListnPage(radioProgramId);
                    break;
                case(3):
                    displayChangeRadioProgSongOrdPricePage(radioProgramId);
                    break;
                case(4):
                    displayAddPlaylistToRadioProgramPage(radioProgramId);
                    break;
                case(5):
                    displayRemovePlaylistFromRadioProgramPage(radioProgramId);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayRemovePlaylistFromRadioProgramPage(Long radioProgramId) {
        System.out.println("--------------------------------");
        System.out.println("Enter playlist id to remove:");

        Long playlistId = Long.parseLong(input.nextLine());
        boolean result = radioProgramService.removePlaylistFromProgram(radioProgramId, playlistId);

        if (result)
            System.out.println("Playlist was successfully removed.");
        else
            System.out.println("Error: Unsuccessful. Invalid program or playlist id.");
    }

    private void displayAddPlaylistToRadioProgramPage(Long radioProgramId) {
        System.out.println("--------------------------------");
        System.out.println("Enter playlist id to add:");

        Long playlistId = Long.parseLong(input.nextLine());
        boolean result = radioProgramService.addPlaylistToProgram(radioProgramId, playlistId);

        if (result)
            System.out.println("Playlist was successfully added.");
        else
            System.out.println("Error: Unsuccessful. Invalid program or playlist id.");
    }

    private void displayChangeRadioProgSongOrdPricePage(Long radioProgramId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new monthly listeners of the radio program:");

        int newMonthlyListeners = Integer.parseInt(input.nextLine());
        radioProgramService.updateMonthlyListeners(radioProgramId, newMonthlyListeners);
        System.out.println("Radio program update successful.");
    }

    private void displayChangeRadioProgMonthListnPage(Long radioProgramId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new monthly listeners of the radio program:");

        int newMonthlyListeners = Integer.parseInt(input.nextLine());
        boolean result = radioProgramService.updateMonthlyListeners(radioProgramId, newMonthlyListeners);

        if (result)
            System.out.println("Radio program update successful.");
        else
            System.out.println("Error: Unsuccessful. Monthly listeners value should be positive.");
    }

    private void displayChangeRadioProgramNamePage(Long radioProgramId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the radio program:");

        String newRadioProgramName = input.nextLine();
        boolean result = radioProgramService.updateRadioProgramName(radioProgramId, newRadioProgramName);

        if (result)
            System.out.println("Radio program update successful.");
        else
            System.out.println("Error: Unsuccessful. Radio program with such name already exists.");
    }

    private void displayDeleteRadioProgramByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter name of a radio program to delete:");

        String radioProgramName = input.nextLine();

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the radio program? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = radioProgramService.deleteRadioProgram(radioProgramName);
                    if (result)
                        System.out.println("Radio program successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid radio program name.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayDeleteRadioProgramByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a radio program to delete:");

        Long radioProgramId = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the radio program? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = radioProgramService.deleteRadioProgram(radioProgramId);
                    if (result)
                        System.out.println("Radio program successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid radio program id.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddRadioProgramPage() {
        String radioProgramName;
        int monthlyListeners;
        int songOrderPrice;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter radio program name:");
        radioProgramName = input.nextLine();

        System.out.println("2. Enter radio program monthly listeners:");
        monthlyListeners = Integer.parseInt(input.nextLine());

        System.out.println("3. Enter radio program song order price:");
        songOrderPrice = Integer.parseInt(input.nextLine());

        boolean result = radioProgramService.addRadioProgram(radioProgramName, monthlyListeners, songOrderPrice);

        if (result)
            System.out.println("Radio program added successfully.");
        else
            System.out.println("Error: Unsuccessful. Radio program with such name already exists.");
    }


    private void displayProgramPlaylistsPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter radio program id: ");

        Long radioProgramId = Long.parseLong(input.nextLine());

        System.out.println("All playlists:");

        List<Playlist> playlists = new ArrayList<>(radioProgramService.getProgramPlaylists(radioProgramId));
        System.out.println(JsonConverter.getConvertedToJson(playlists));
    }

    private void displayRadioProgramByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter radio program name: ");

        String radioProgramName = input.nextLine();
        RadioProgram radioProgram = radioProgramService.getProgramByName(radioProgramName);

        if (radioProgram != null)
            System.out.println(JsonConverter.getConvertedToJson(radioProgram));
        else
            System.out.println("No radio program with such name.");
    }

    private void displayRadioProgramByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter radio program id: ");

        Long radioProgramId = Long.parseLong(input.nextLine());
        RadioProgram radioProgram = radioProgramService.getProgramById(radioProgramId);

        if (radioProgram != null)
            System.out.println(JsonConverter.getConvertedToJson(radioProgram));
        else
            System.out.println("No radio program with such ID.");
    }

    private void displayAllRadioProgramsPage() {
        System.out.println("--------------------------------");
        System.out.println("All radio programs:");
        List<RadioProgram> radioPrograms = radioProgramService.getAllRadioPrograms();
        System.out.println(JsonConverter.getConvertedToJson(radioPrograms));
    }

    //</editor-fold>

    //<editor-fold desc="RadioDj display section">

    private void displayEditDjPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a dj to edit.");

        Long djId = Long.parseLong(input.nextLine());

        if (radioDjService.getRadioDjById(djId) == null){
            System.out.println("Error: Unsuccessful. No dj with such id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change dj name");
            System.out.println("        2. Change dj nickname");
            System.out.println("        3. Change dj program");
            System.out.println("        0. Back to radio dj menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangeDjNamePage(djId);
                    break;
                case(2):
                    displayChangeDjNicknamePage(djId);
                    break;
                case(3):
                    displayChangeDjProgramPage(djId);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeDjProgramPage(Long djId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new program id of the dj:");

        Long newProgramId = Long.parseLong(input.nextLine());
        radioDjService.updateRadioDjProgram(djId, newProgramId);
        System.out.println("Dj update successful.");
    }

    private void displayChangeDjNamePage(Long djId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the dj:");

        String newDjName = input.nextLine();
        radioDjService.updateRadioDjName(djId, newDjName);
        System.out.println("Dj update successful.");
    }

    private void displayChangeDjNicknamePage(Long djId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new nickname of the dj:");

        String newDjNickname = input.nextLine();
        radioDjService.updateDjNickname(djId, newDjNickname);
        System.out.println("Dj update successful.");
    }

    private void displayDeleteDjByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a dj to delete:");

        Long djId = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the song? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = radioDjService.deleteDj(djId);
                    if (result)
                        System.out.println("Dj successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid dj id.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddDjPage() {
        String djName;
        String djNickname;
        Long djProgramId;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter dj name:");
        djName = input.nextLine();

        System.out.println("2. Enter dj nickname:");
        djNickname = input.nextLine();

        System.out.println("3. Enter dj program id:");
        djProgramId = Long.parseLong(input.nextLine());

        boolean result = radioDjService.addRadioDj(djName, djNickname, djProgramId);

        if (result)
            System.out.println("Dj added successfully.");
        else
            System.out.println("Error: Unsuccessful. Dj with such nickname already exists.");
    }

    private void displayDjByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter dj id: ");

        Long djId = Long.parseLong(input.nextLine());
        RadioDj radioDj = radioDjService.getRadioDjById(djId);

        if (radioDj != null)
            System.out.println(JsonConverter.getConvertedToJson(radioDj));
        else
            System.out.println("No dj with such ID.");
    }

    private void displayAllDjsPage() {
        System.out.println("--------------------------------");
        System.out.println("All djs:");
        List<RadioDj> radioDjs = radioDjService.getAllRadioDjs();
        System.out.println(JsonConverter.getConvertedToJson(radioDjs));
    }

    //</editor-fold>

    //<editor-fold desc="Song display section">

    private void displayEditSongPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a song to edit.");

        Long songId = Long.parseLong(input.nextLine());

        if (songService.getSongById(songId) == null){
            System.out.println("Error: Unsuccessful. No song with such id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change song name");
            System.out.println("        2. Change song album");
            System.out.println("        3. Change song duration");
            System.out.println("        4. Change song monthly orders");
            System.out.println("        5. Change song rating");
            System.out.println("        0. Back to song menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangeSongNamePage(songId);
                    break;
                case(2):
                    displayChangeSongAlbumPage(songId);
                    break;
                case(3):
                    displayChangeSongDurationPage(songId);
                    break;
                case(4):
                    displayChangeSongMonthlyOrdersPage(songId);
                    break;
                case(5):
                    displayChangeSongRatingPage(songId);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeSongRatingPage(Long songId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new rating of the song:");

        int newRating = Integer.parseInt(input.nextLine());
        songService.updateRating(songId, newRating);
    }

    private void displayChangeSongMonthlyOrdersPage(Long songId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new monthly orders of the song:");

        int newMonthlyOrders = Integer.parseInt(input.nextLine());
        songService.updateMonthlyOrders(songId, newMonthlyOrders);
    }

    private void displayChangeSongDurationPage(Long songId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new duration of the song:");

        int newDuration = Integer.parseInt(input.nextLine());
        songService.updateDuration(songId, newDuration);
    }

    private void displayChangeSongAlbumPage(Long songId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new album id of the song:");

        Long newAlbumId = Long.parseLong(input.nextLine());
        boolean result = songService.updateSongAlbum(songId, newAlbumId);

        if (result)
            System.out.println("Song update successful.");
        else
            System.out.println("Error: Unsuccessful. There is no album with such ID.");
    }

    private void displayChangeSongNamePage(Long songId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the song:");

        String newSongName = input.nextLine();
        songService.updateSongName(songId, newSongName);
        System.out.println("Song update successful.");
    }

    private void displayDeleteSongByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a song to delete:");

        Long songId = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the song? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = songService.deleteSong(songId);
                    if (result)
                        System.out.println("Song successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid song id.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddSongPage() {
        String songName;
        Long albumId;
        int duration;
        int monthlyOrders;
        int rating;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter song name:");
        songName = input.nextLine();

        System.out.println("2. Enter album id:");
        albumId = Long.parseLong(input.nextLine());

        System.out.println("3. Enter duration:");
        duration = Integer.parseInt(input.nextLine());

        System.out.println("4. Enter monthly orders:");
        monthlyOrders = Integer.parseInt(input.nextLine());

        System.out.println("5. Enter rating:");
        rating = Integer.parseInt(input.nextLine());

        boolean result = songService.addSong(songName, albumId, duration, monthlyOrders, rating);

        if (!result) {
            System.out.println("Error: Unsuccessful. Invalid album ID.");
        } else
            System.out.println("Song added successfully.");
    }

    private void displaySongByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter song id: ");

        Long songId = Long.parseLong(input.nextLine());
        Song song = songService.getSongById(songId);

        if (song != null)
            System.out.println(JsonConverter.getConvertedToJson(song));
        else
            System.out.println("No song with such ID.");
    }

    private void displayAllSongsPage() {
        System.out.println("--------------------------------");
        System.out.println("All songs:");
        List<Song> songs = songService.getAllSongs();
        System.out.println(JsonConverter.getConvertedToJson(songs));
    }

    //</editor-fold>

    //<editor-fold desc="Label display section">

    private void displayEditLabelPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a label to edit.");

        Long labelId = Long.parseLong(input.nextLine());

        if (labelService.getLabelById(labelId) == null){
            System.out.println("Error: Unsuccessful. No label with such id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change label name");
            System.out.println("        2. Change label creation date");
            System.out.println("        0. Back to label menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangeLabelNamePage(labelId);
                    break;
                case(2):
                    displayChangeLabelCreationDatePage(labelId);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeLabelCreationDatePage(Long labelId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new creation date of the label (YYYY-M-D):");

        String newCreationDate = input.nextLine();
        boolean result = labelService.updateLabelCreationDate(labelId, newCreationDate);

        if (result)
            System.out.println("Label update successful.");
        else
            System.out.println("Error: Unsuccessful. Inavlid date format.");
    }

    private void displayChangeLabelNamePage(Long labelId) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the label:");

        String newLabelName = input.nextLine();
        boolean result = labelService.updateLabelName(labelId, newLabelName);

        if (result)
            System.out.println("Label update successful.");
        else
            System.out.println("Error: Unsuccessful. Label with such name already exists.");
    }

    private void displayDeleteLabelByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id of a label to delete:");

        Long labelId = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the label? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = labelService.deleteLabel(labelId);
                    if (result)
                        System.out.println("Label successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid label id.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddLabelPage() {
        String labelName;
        String labelCreationDate;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter label name:");
        labelName = input.nextLine();

        System.out.println("2. Enter label creation date (YYYY-M-D):");
        labelCreationDate = input.nextLine();

        boolean result = labelService.addLabel(labelName, labelCreationDate);

        if (!result)
            System.out.println("Error: Unsuccessful. Label with such name exists or invalid date format.");
        else
            System.out.println("Label added successfully.");
    }

    private void displayLabelByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter label id: ");

        Long labelId = Long.parseLong(input.nextLine());
        Label label = labelService.getLabelById(labelId);

        if (label != null)
            System.out.println(JsonConverter.getConvertedToJson(label));
        else
            System.out.println("No label with such ID.");
    }

    private void displayAllLabelsPage() {
        System.out.println("--------------------------------");
        System.out.println("All labels:");
        List<Label> labels = labelService.getAllLabels();
        System.out.println(JsonConverter.getConvertedToJson(labels));
    }

    //</editor-fold>

    //<editor-fold desc="Genre display section">

    private void displayEditGenrePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter code of a genre to edit.");

        Long genreCode = Long.parseLong(input.nextLine());

        if (genreService.getGenreByCode(genreCode) == null){
            System.out.println("Error: Unsuccessful. No genre with such code.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change genre name");
            System.out.println("        2. Change genre description");
            System.out.println("        0. Back to genre menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangeGenreNamePage(genreCode);
                    break;
                case(2):
                    displayChangeGenreDescriptionPage(genreCode);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeGenreDescriptionPage(Long genreCode) {
        System.out.println("--------------------------------");
        System.out.println("Enter new description of the genre:");

        String newGenreDescription = input.nextLine();
        genreService.setGenreDescription(genreCode, newGenreDescription);
    }

    private void displayChangeGenreNamePage(Long genreCode) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the genre:");

        String newGenreName = input.nextLine();
        boolean result = genreService.setGenreName(genreCode, newGenreName);

        if (result)
            System.out.println("Genre update successful.");
        else
            System.out.println("Error: Unsuccessful. Genre with such name already exists.");
    }

    private void displayDeleteGenreByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter name of a genre to delete:");

        String genreName = input.nextLine();

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the genre? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = genreService.deleteGenre(genreName);
                    if (result)
                        System.out.println("Genre successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid genre name.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayDeleteGenreByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter code of a genre to delete:");

        Long genreCode = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the genre? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = artistService.deleteArtist(genreCode);
                    if (result)
                        System.out.println("Genre successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid genre code.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddGenrePage() {
        String genreName;
        String genreDescription;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter genre name:");
        genreName = input.nextLine();

        System.out.println("2. Enter genre description:");
        genreDescription = input.nextLine();

        boolean result = genreService.addGenre(genreName, genreDescription);

        if (!result)
            System.out.println("Error: Unsuccessful. Genre with such name already exists.");
        else
            System.out.println("Genre added successfully.");
    }

    private void displayGenreByCodePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter genre code: ");

        Long genreCode = Long.parseLong(input.nextLine());
        Genre genre = genreService.getGenreByCode(genreCode);

        if (genre != null)
            System.out.println(JsonConverter.getConvertedToJson(genre));
        else
            System.out.println("No genre with such code.");
    }

    private void displayAllGenresPage() {
        System.out.println("--------------------------------");
        System.out.println("All genres:");
        List<Genre> genres = genreService.getAllGenres();
        System.out.println(JsonConverter.getConvertedToJson(genres));
    }

    //</editor-fold>

    //<editor-fold desc="Artist display section">

    private void displayEditArtistPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter ID of an artist to edit.");

        Long id = Long.parseLong(input.nextLine());

        if (artistService.getArtistById(id) == null){
            System.out.println("Error: Unsuccessful. No artist with such ID.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("--------------------------------");
            System.out.println("        Choose what to edit: ");
            System.out.println("        1. Change artist name");
            System.out.println("        2. Change artist career begin date");
            System.out.println("        3. Change artist rating");
            System.out.println("        0. Back to artist menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

            switch (option){
                case(1):
                    displayChangeArtistNamePage(id);
                    break;
                case(2):
                    displayChangeArtistCarBegDatePage(id);
                    break;
                case(3):
                    displayChangeArtistRatingPage(id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeArtistRatingPage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new artist rating:");

        int newRating = Integer.parseInt(input.nextLine());
        boolean result = artistService.updateArtistRating(id, newRating);

        if (result)
            System.out.println("Artist update successful.");
        else
            System.out.println("Error: Unsuccessful. Rating must be positive.");
    }

    private void displayChangeArtistCarBegDatePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new career begin date of the artist (YYYY-M-D):");

        String newCareerBeginDate = input.nextLine();
        boolean result = artistService.updateArtistCareerBeginDate(id, newCareerBeginDate);

        if (result)
            System.out.println("Artist update successful.");
        else
            System.out.println("Error: Unsuccessful. Invalid date format.");
    }

    private void displayChangeArtistNamePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the artist:");

        String newArtistName = input.nextLine();
        boolean result = artistService.updateArtistName(id, newArtistName);

        if (result)
            System.out.println("Artist update successful.");
        else
            System.out.println("Error: Unsuccessful. Artist with such name already exists.");
    }

    private void displayDeleteArtistByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter name of an artist to delete:");

        String name = input.nextLine();

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the artist? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = artistService.deleteArtist(name);
                    if (result)
                        System.out.println("Artist successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid name.");
                    show = false;
                    break;
                case("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayDeleteArtistByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter ID of an artist to delete:");

        Long id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the artist? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = artistService.deleteArtist(id);
                    if (result)
                        System.out.println("Artist successfully deleted.");
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

    private void displayAddArtistPage() {
        String artistName;
        String careerBeginDate;
        int rating;

        System.out.println("--------------------------------");
        System.out.println("Enter input data.");
        System.out.println("1. Enter artist name:");
        artistName = input.nextLine();

        System.out.println("2. Enter artist career begin date (YYYY-M-D):");
        careerBeginDate = input.nextLine();

        System.out.println("3. Enter artist rating:");
        rating = Integer.parseInt(input.nextLine());

        boolean result = artistService.addArtist(artistName, careerBeginDate, rating);

        if (!result) {
            System.out.println("Error: Unsuccessful. Artist with such name already exists.");
        } else
            System.out.println("Artist added successfully.");
    }

    private void displayArtistByNamePage() {
        System.out.println("--------------------------------");
        System.out.println("Enter name: ");

        String name = input.nextLine();
        Artist artist = artistService.getArtistByName(name);

        if (artist != null)
            System.out.println(JsonConverter.getConvertedToJson(artist));
        else
            System.out.println("No artist with such ID.");
    }

    private void displayArtistByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id: ");

        Long id = Long.parseLong(input.nextLine());
        Artist artist = artistService.getArtistById(id);

        if (artist != null)
            System.out.println(JsonConverter.getConvertedToJson(artist));
        else
            System.out.println("No artist with such ID.");
    }

    private void displayAllArtistsPage() {
        System.out.println("--------------------------------");
        System.out.println("All artists:");
        List<Artist> artists = artistService.getAllArtists();
        System.out.println(JsonConverter.getConvertedToJson(artists));
    }

    //</editor-fold>

    //<editor-fold desc="Album display section">

    private void displayEditAlbumPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter ID of an album to edit.");

        Long id = Long.parseLong(input.nextLine());

        if (albumService.getAlbumById(id) == null){
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
            System.out.println("        0. Back to album menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = 100;
            }

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
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeAlbNumOfTracksPage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new number of tracks:");

        Integer newNumOfTracks = Integer.parseInt(input.nextLine());
        boolean result = albumService.updateNumberOfTracks(id, newNumOfTracks);

        if (result)
            System.out.println("Album update successful.");
        else
            System.out.println("Error: Unsuccessful. Invalid album id.");
    }

    private void displayChangeAlbumArtistIdPage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new artist ID:");

        Long artistId = Long.parseLong(input.nextLine());
        boolean result = albumService.updateAlbumArtist(id, artistId);

        if(result)
            System.out.println("Album update successful.");
        else
            System.out.println("Error: Unsuccessful. Invalid album id.");
    }

    private void displayChangeAlbumArtistNamePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new artist name:");

        String artistName = input.nextLine();
        boolean result = albumService.updateAlbumArtist(id, artistName);

        if (result)
            System.out.println("Album update successful.");
        else
            System.out.println("Error: Unsuccessful. Invalid album id.");
    }

    private void displayChangeAlbumGenrePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new genre code:");

        Long genreCode = Long.parseLong(input.nextLine());
        boolean result = albumService.updateAlbumGenre(id, genreCode);

        if (result)
            System.out.println("Album update successful.");
        else
            System.out.println("Error: Unsuccessful. Invalid album id.");
    }

    private void displayChangeAlbumNamePage(Long id) {
        System.out.println("--------------------------------");
        System.out.println("Enter new name of the album:");

        String newAlbumName = input.nextLine();
        boolean result = albumService.updateAlbumName(id, newAlbumName);

        if (result)
            System.out.println("Album update successful.");
        else
            System.out.println("Error: Unsuccessful. Invalid album id.");
    }

    private void displayDeleteAlbumPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter ID of an album to delete.");

        Long id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while(show){
            System.out.println("Are you sure you want to delete the album? (y/n)");

            String option = input.nextLine();
            switch (option){
                case("y"):
                    result = albumService.deleteAlbum(id);
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

        boolean result = albumService.addAlbum(albumName, genreCode, artistId, numberOfTracks, labelId);

        if (!result)
            System.out.println("Error: Unsuccessful. Invalid data.");
        else
            System.out.println("Album added successfully.");
    }

    private void displayAlbumByIdPage() {
        System.out.println("--------------------------------");
        System.out.println("Enter id: ");

        Long id = Long.parseLong(input.nextLine());
        Album album = albumService.getAlbumById(id);

        if (album != null)
            System.out.println(JsonConverter.getConvertedToJson(album));
        else
            System.out.println("No album with such ID.");
    }

    private void displayAllAlbumsPage() {
        System.out.println("--------------------------------");
        System.out.println("All albums:");
        List<Album> albums = albumService.getAllAlbums();
        System.out.println(JsonConverter.getConvertedToJson(albums));
    }
    //</editor-fold>
}
