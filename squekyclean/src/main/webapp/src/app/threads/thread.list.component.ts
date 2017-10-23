import { Component } from '@angular/core';
import { ThreadService } from './thread.service'
import { Thread } from './thread'
import { ConfirmationDialog } from "../confirm-dialog/confirmation-dialog";
import { MdDialog, MdDialogRef } from '@angular/material';

@Component({
    selector: 'thread-list',
    templateUrl: './thread.list.component.html',
    styleUrls: ['./thread.component.css']
})
export class ThreadListComponent {
    threads: Thread[];
    dialogRef: MdDialogRef<ConfirmationDialog>;

    constructor(public dialog: MdDialog, private threadService: ThreadService) {
        threadService.getThreads().subscribe(data => {
            this.threads = data;
        });
    }


 

    createNewThread(): void {
        this.dialogRef = this.dialog.open(ConfirmationDialog, {
            disableClose: false
        });
        this.dialogRef.componentInstance.confirmMessage = "Please enter the thread name:"

        this.dialogRef.afterClosed().subscribe(result => {
            if (result && this.dialogRef.componentInstance.val) {
                this.threadService.newThread(this.dialogRef.componentInstance.val).subscribe(res => {
                    this.threadService.getThreads().subscribe(data => {
                        this.threads = data;
                    });
                });
            }
            this.dialogRef = null;
        });
    }
}
