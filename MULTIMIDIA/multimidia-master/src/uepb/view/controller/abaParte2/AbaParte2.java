package uepb.view.controller.abaParte2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AbaParte2 implements Initializable {
	
	private ToggleButton toggleButtonDCTCeu;
	private ToggleButton toggleButtonDCTGrama;
	private ToggleButton toggleButtonDCTCeuEGrama;
	
	private Pane paneMatriz;
	private Pane paneGrafico;
	
	private TextField textFieldZeros;
	
	private ImageView imageViewDCTCeu;
	private ImageView imageViewDCTGrama;
	private ImageView imageViewDCTCeuEGrama;

	public AbaParte2(ToggleButton toggleButtonDCTCeu,
			ToggleButton toggleButtonDCTGrama,
			ToggleButton toggleButtonDCTCeuEGrama, Pane paneMatriz,
			Pane paneGrafico, TextField textFieldZeros,
			ImageView imageViewDCTCeu, ImageView imageViewDCTGrama,
			ImageView imageViewDCTCeuEGrama) {
		super();
		this.toggleButtonDCTCeu = toggleButtonDCTCeu;
		this.toggleButtonDCTGrama = toggleButtonDCTGrama;
		this.toggleButtonDCTCeuEGrama = toggleButtonDCTCeuEGrama;
		this.paneMatriz = paneMatriz;
		this.paneGrafico = paneGrafico;
		this.textFieldZeros = textFieldZeros;
		this.imageViewDCTCeu = imageViewDCTCeu;
		this.imageViewDCTGrama = imageViewDCTGrama;
		this.imageViewDCTCeuEGrama = imageViewDCTCeuEGrama;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		toggleButtonDCTGrama.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonDCTGrama.setSelected(true);
				toggleButtonDCTCeu.setSelected(false);
				toggleButtonDCTCeuEGrama.setSelected(false);

				Image matriz = new Image("/uepb/icones/DCTMatrizGrama.png");
				Image grafico = new Image("/uepb/icones/DCTGrama.png");

				ImageView mat = new ImageView();
				ImageView gra = new ImageView();

				mat.setImage(matriz);
				gra.setImage(grafico);
				
				mat.setFitHeight(180);
				mat.setFitWidth(300);

				gra.setFitHeight(200);
				gra.setFitWidth(200);
				
				paneMatriz.getChildren().add(mat);
				paneGrafico.getChildren().add(gra);
				
				textFieldZeros.setText("36");
			}
		});
		
		toggleButtonDCTCeu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonDCTGrama.setSelected(false);
				toggleButtonDCTCeu.setSelected(true);
				toggleButtonDCTCeuEGrama.setSelected(false);

				Image matriz = new Image("/uepb/icones/DCTMatrizCeu.png");
				Image grafico = new Image("/uepb/icones/DCTCeu.png");

				ImageView mat = new ImageView();
				ImageView gra = new ImageView();

				mat.setImage(matriz);
				gra.setImage(grafico);
				
				mat.setFitHeight(180);
				mat.setFitWidth(300);

				gra.setFitHeight(200);
				gra.setFitWidth(200);
				
				paneMatriz.getChildren().add(mat);
				paneGrafico.getChildren().add(gra);
				
				textFieldZeros.setText("36");
				
			}
		});
		
		toggleButtonDCTCeuEGrama.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonDCTGrama.setSelected(false);
				toggleButtonDCTCeu.setSelected(false);
				toggleButtonDCTCeuEGrama.setSelected(true);

				Image matriz = new Image("/uepb/icones/DCTMatrizCeuEGrama.png");
				Image grafico = new Image("/uepb/icones/DCTHorizonte.png");

				ImageView mat = new ImageView();
				ImageView gra = new ImageView();

				mat.setImage(matriz);
				gra.setImage(grafico);
				
				mat.setFitHeight(180);
				mat.setFitWidth(300);

				gra.setFitHeight(200);
				gra.setFitWidth(200);
				
				paneMatriz.getChildren().add(mat);
				paneGrafico.getChildren().add(gra);
				
				textFieldZeros.setText("36");
			}
		});
		
		Image imagemDCTGrama = new Image("/uepb/icones/grama.png");
		imageViewDCTGrama.setImage(imagemDCTGrama);

		Image imagemDCTCeu = new Image("/uepb/icones/ceu.png");
		imageViewDCTCeu.setImage(imagemDCTCeu);

		Image imagemDCTCeuEGrama = new Image("/uepb/icones/ceuGrama.png");
		imageViewDCTCeuEGrama.setImage(imagemDCTCeuEGrama);

		toggleButtonDCTCeu.setGraphic(imageViewDCTCeu);
		toggleButtonDCTGrama.setGraphic(imageViewDCTGrama);
		toggleButtonDCTCeuEGrama.setGraphic(imageViewDCTCeuEGrama);
		
	}

}
