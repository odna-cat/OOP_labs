package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.*;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import java.awt.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class CartScreenController {
    private Cart cart;
    private CartScreen cartFrame;
    private FilteredList<Media> filteredByIdList;
    private FilteredList<Media> filteredByTitleList;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        filteredByIdList = new FilteredList<>(cart.getItemsOrdered(), temp -> true);
        filteredByTitleList = new FilteredList<>(cart.getItemsOrdered(), temp -> true);
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {

                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue,
                            Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

                tblMedia.textProperty().addListener(new ChangeListener<String>() {
                    
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                        showFilteredMedia(newValue);
                    }
                })
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
}
