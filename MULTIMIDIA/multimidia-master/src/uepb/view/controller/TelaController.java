package uepb.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import uepb.controller.ConverterBlocosParaYUV;
import uepb.model.Bloco;
import uepb.view.controller.abaParte1.AbaParte1;
import uepb.view.controller.abaParte2.AbaParte2;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TelaController implements Initializable {

	// PARTE 1

	@FXML
	private ToggleButton toggleButtonCarregarCeu;
	@FXML
	private ToggleButton toggleButtonCarregarGrama;
	@FXML
	private ToggleButton toggleButtonCarregarCeuEGrama;

	@FXML
	private Pane paneY;
	@FXML
	private Pane paneU;
	@FXML
	private Pane paneV;

	@FXML
	private ImageView imageViewCarregarCeu;
	@FXML
	private ImageView imageViewCarregarGrama;
	@FXML
	private ImageView imageViewCarregarCeuEGrama;

	// PARTE 2

	@FXML
	private ToggleButton toggleButtonDCTCeu;
	@FXML
	private ToggleButton toggleButtonDCTGrama;
	@FXML
	private ToggleButton toggleButtonDCTCeuEGrama;

	@FXML
	private Pane paneMatriz;
	@FXML
	private Pane paneGrafico;

	@FXML
	private TextField textFieldZeros;

	@FXML
	private ImageView imageViewDCTCeu;
	@FXML
	private ImageView imageViewDCTGrama;
	@FXML
	private ImageView imageViewDCTCeuEGrama;

	// Controllers

	private AbaParte1 abaParte1;
	private AbaParte2 abaParte2;

	public void initialize(final URL location, final ResourceBundle resources) {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				abaParte1 = new AbaParte1(toggleButtonCarregarCeu,
						toggleButtonCarregarGrama,
						toggleButtonCarregarCeuEGrama, paneY, paneU, paneV,
						imageViewCarregarCeu, imageViewCarregarGrama,
						imageViewCarregarCeuEGrama);

				abaParte2 = new AbaParte2(toggleButtonDCTCeu,
						toggleButtonDCTGrama, toggleButtonDCTCeuEGrama,
						paneMatriz, paneGrafico, textFieldZeros,
						imageViewDCTCeu, imageViewDCTGrama,
						imageViewDCTCeuEGrama);

				abaParte1.initialize(location, resources);
				abaParte2.initialize(location, resources);
			}
		});

	}

}
