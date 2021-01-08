import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Device } from 'app/models/device';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  
  url= environment.url;

  constructor(private http: HttpClient) {

  }

  addDevice(device: any): Observable<Device> {
    return this.http.post<Device>(`${this.url}`+`/device`, device);
  }

  public editDevice(device: any): Observable<Device> {
    return this.http.put(`${this.url}` + `/device`, device)
      .pipe(
        map((res: any) => {
          console.log(res);
          return res;
        }));
  }

  public getTotalNoOfDevices(): Observable<number>{
    return this.http.get<number>(`${this.url}`+`/totalNoOfDevices`);
  }

  public getTotalNoOfDevicesON(): Observable<number>{
    return this.http.get<number>(`${this.url}`+`/totalNoOfDevicesON`);
  }

  public getTotalPower() : Observable<number>{
    return this.http.get<number>(`${this.url}`+`/totalPower`);
  }

  public getRoomDevices(roomId: String): Observable<Device[]>{
    let params = new HttpParams().set('roomId', roomId.toString());
    console.log(params.toString());
    return this.http.get<Device[]>(`${this.url}`+`/roomDevices`,  { params });
  }

  public getAllDevices(): Observable<Device[]>{
    return this.http.get<Device[]>(`${this.url}`+`/allDevices`);
  }

}
