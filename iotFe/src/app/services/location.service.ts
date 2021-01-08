import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Room } from 'app/models/room';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  url= environment.url;

  constructor(private http: HttpClient) {

  }

  public getAllRooms(): Observable<Room[]>{
    return this.http.get<Room[]>(`${this.url}`+`/rooms`);
  }

  public getTotalNoOfRooms(): Observable<number>{
    return this.http.get<number>(`${this.url}`+`/totalNoOfRooms`);
  }
}
