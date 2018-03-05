import { Component, OnInit } from '@angular/core';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { FormControl, FormGroup, FormBuilder, FormsModule } from '@angular/forms';
import { Clone } from '../clone';
import { CloneService} from '../servicos/clone.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-clone-form',
	templateUrl: './clone-form.component.html',
	styleUrls: ['./clone-form.component.css']
})

export class CloneFormComponent implements OnInit {
	private clone: Clone = new Clone();
	form: FormGroup;

	constructor(private _cloneServico: CloneService, private _router:Router){
		this.clone = _cloneServico.getter();}

		pattern = new RegExp('[A-Z]{3}[0-9]{4}');

		ngOnInit() {
			this.clone = this._cloneServico.getter();

		}


		bsValue: Date = new Date();

		itemStringsLeft: string[] = [
		'Braço Mecâncico',
		'Esqueleto Reforçado',
		'Sentidos Aguçados',
		'Pele Adaptiva',
		'Raio Laser'
		];

		itemStringsRight: string[];



		processForm(){
			let result =this.pattern.test(this.clone.nome);
			console.log(this.clone.nome);
			console.log(this.pattern);
			console.log(result);
			if(result == true)	{	
				if(!this.clone.id){
					this.clone.adcionais = this.itemStringsRight;
					this._cloneServico.novoClone(this.clone).subscribe((clone)=>{
						console.log(Clone);
						this._router.navigate(['/']);
					}, (Error)=>{console.log(Error);
					});
				}else{
					this._cloneServico.updateClone(this.clone).subscribe((clone)=>{
						this._router.navigate(['/']);
						console.log(Clone);
					}, (Error)=>{console.log(Error);
					});}}else{		
						alert("Padrão Invalido");			
					}}

				}
