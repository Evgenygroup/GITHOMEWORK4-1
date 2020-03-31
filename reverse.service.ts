import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReverseService {

  constructor() {
  }

  reverseString(str: string) {
    return str.split("").reverse().join("");
  }
}
