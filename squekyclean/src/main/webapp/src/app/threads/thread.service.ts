import { Injectable } from '@angular/core';
import { Thread } from './thread'
import {HttpClient} from '@angular/common/http';
import { Observable } from "rxjs/Observable";

@Injectable()
export class ThreadService {
    constructor(private http: HttpClient) {}

    getThreads() : Observable<Thread []> {
        return this.http.get<Thread[]>('/api/thread');
    }

    getThread(id : number) : Observable<Thread> {
        return this.http.get<Thread>('/api/thread/'+id);
    }

    newThread(threadName : string) :  Observable<Object>{
        const body = {threadName : threadName};
        return this.http.post('/api/thread', body);
    }
    //private long threadId;
    // private String author;
    // private String content;
    post(threadId:number, author : string, content: string): Observable<Object>{
        const body = {author : author, threadId: threadId, content : content};
        return this.http.post('/api/post', body);
    }

    subscribe(threadId : number, email : string) : Observable<Object>{
        const body = {threadId : threadId, email : email};
        return this.http.post('/api/subscribe', body);
    }
}