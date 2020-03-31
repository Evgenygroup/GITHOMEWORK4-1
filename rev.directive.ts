import {Directive, ElementRef} from '@angular/core';
import {TranslationsService} from "../../services/translations.service";
import {ReverseService} from "../../services/reverse/reverse.service";

@Directive({
  selector: '[appRev]'
})
export class RevDirective {

  private stringToReverse: string;

  constructor(private element: ElementRef, private reverseService: ReverseService) {
  }

  ngAfterViewInit() {
    this.stringToReverse = this.element.nativeElement.innerText;
    this.element.nativeElement.innerText = this.reverseService.reverseString(this.stringToReverse)

  }

}
