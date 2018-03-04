import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal-delete',
  templateUrl: './modal-delete.component.html'
})
export class ModalDeleteComponent implements OnInit {

  @Input() message: string;

  @Output() confirm = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  emitConfirmEvent() {
    this.confirm.emit();
  }
}
