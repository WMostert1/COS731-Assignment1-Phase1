import { Component, Input, OnInit } from '@angular/core';
import { Thread } from "./thread";
import { ThreadService } from "./thread.service";
import { ActivatedRoute } from "@angular/router";
import { Post } from "./posts/post";
import { CognitoUtil } from "../service/cognito.service";
import { ToastsManager } from "ng2-toastr/ng2-toastr";

@Component({
  selector: 'thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.css']
})
export class ThreadComponent implements OnInit{
  constructor(private route: ActivatedRoute,private threadService : ThreadService, private cognitoUtil: CognitoUtil, private toastr: ToastsManager){}

  thread : Thread;
  posts : Post [];

  postContent : string;

  ngOnInit(): void {
    let id : number = parseInt(this.route.snapshot.paramMap.get('id'));

    this.threadService.getThread(id).subscribe(data => {
      this.thread = data;
      this.posts = this.thread.posts;
    });
  }

  subscribe() : void{
      this.threadService.subscribe(this.thread.id,this.cognitoUtil.getCurrentUser().getUsername()).subscribe(data => {
        this.toastr.info("Please check your email at " + this.cognitoUtil.getCurrentUser().getUsername()+" to confirm subecription to "+this.thread.threadName+"@ SquekyClean");
      });
  }

  post() : void{
    this.threadService.post(this.thread.id,this.cognitoUtil.getCurrentUser().getUsername(), this.postContent).subscribe(res =>{
      this.threadService.getThread(this.thread.id).subscribe(data => {
      this.thread = data;
      this.posts = this.thread.posts;
    });
    })
  }
}
