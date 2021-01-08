import { Room } from "./room";

export class Device {
    id: string;
    name: string;
    type:string;
    location: Room;
    state: string;
    min_value: number;
    max_value: number;
}