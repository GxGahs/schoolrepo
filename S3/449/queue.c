/*
 * Developed by R. E. Bryant, 2017
 * Extended to store strings, 2018
 */

/*
 * This program implements a queue supporting both FIFO and LIFO
 * operations.
 *
 * It uses a singly-linked list to represent the set of queue elements
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "harness.h"
#include "queue.h"

/*
  Create empty queue.
  Return NULL if could not allocate space.
*/
queue_t *q_new()
{
    queue_t *q =  malloc(sizeof(queue_t));
    /* What if malloc returned NULL? */
    if (q == NULL) {
    	return NULL;
    }
    q->head = NULL;
    q->tail = NULL;
    q->size = 0;
    return q;
}

/* Free all storage used by queue */
void q_free(queue_t *q)
{
	if (q == NULL) {
		return;
	}

	if (q->head == NULL) {
		free(q);
		return;
	}
	/*
	list_ele_t *aaa = q->head;
	list_ele_t *currhead = q->head;
	list_ele_t *currnext = currhead->next;
	char *tempch = q->head->value;

	while(currhead != NULL) {
		free(currhead);
		free(tempch);
		currhead = currnext;
		currnext = currhead->next;
		tempch = currhead->value;
	}

	//free(currhead);
	free(aaa);
     How about freeing the list elements and the strings? */
    /* Free queue structure */
	list_ele_t *aaa = q->head;
	list_ele_t *bbb = q->head;
	do {
		free(aaa->value);
		bbb = aaa->next;
		free(aaa);
		aaa = bbb;


	} while (aaa != NULL);

	free(q);
}

/*
  Attempt to insert element at head of queue.
  Return true if successful.
  Return false if q is NULL or could not allocate space.
  Argument s points to the string to be stored.
  The function must explicitly allocate space and copy the string into it.
 */
bool q_insert_head(queue_t *q, char *s)
{


	  //newhead
    list_ele_t *newh;
    /* What should you do if the q is NULL? return false*/
    if (q==NULL) {
    	return false;
    }
    //allocate size for our newhead
    newh = malloc(sizeof(list_ele_t));

    //if that fails return false
    if (newh == NULL) {
    	return false;
    }
    /* Don't forget to allocate space for the string and copy it */

  //allocate space for the string
	newh->value = malloc(strlen(s) + 1);

  //if we cant allocate space free our head space and return false
	if (newh->value == NULL) {
		free(newh);
		return false;
	}

  //copy string
	strcpy(newh->value, s);

	/* What if either call to malloc returns NULL? */

  //link
    newh->next = q->head;
    q->head = newh;

    //if q is empty new head is also the tail
	if (q->size == 0) {
		q->tail = newh;
	}
  //increment size of q
	(q->size)++;

    return true;
}


/*
  Attempt to insert element at tail of queue.
  Return true if successful.
  Return false if q is NULL or could not allocate space.
  Argument s points to the string to be stored.
  The function must explicitly allocate space and copy the string into it.
 */
bool q_insert_tail(queue_t *q, char *s)
{
	if (q == NULL) {
		return false;
	}
	//make new tail, allocate mem for struct and value
	list_ele_t *newt;
	newt = malloc(sizeof(list_ele_t));

	if (newt == NULL) {
		return false;
	}

	newt->value = malloc(strlen(s) + 1);

	//satisfies conditions?
	if(newt->value == NULL) {
		free(newt);
		return false;
	}

	//cpy string to value location
	strcpy(newt->value, s);

	//empty queue logic
	if (q->size == 0) {
		q->head = newt;
		q->tail = newt;
		return true;
	}

	//add to back of queue
	newt->next = NULL;
	q->tail->next = newt;
	q->tail = newt;

	//inc size of queue
	(q->size)++;

    /* You need to write the complete code for this function */
    /* Remember: It should operate in O(1) time */
    return true;
}

/*
  Attempt to remove element from head of queue.
  Return true if successful.
  Return false if queue is NULL or empty.
  If sp is non-NULL and an element is removed, copy the removed string to *sp
  (up to a maximum of bufsize-1 characters, plus a null terminator.)
  The space used by the list element and the string should be freed.
*/
bool q_remove_head(queue_t *q, char *sp, size_t bufsize)
{
	//queue is null or empty? return false
	if (q == NULL) {
		return false;
	} else if (q->size == 0) {
		return false;
	}

	//copy the string and then make the last element a null terminator
	//(strncpy pads with 0 if the size of copied str is less than bufsize anyways)
	if (sp != NULL) {
		strncpy(sp,q->head->value,bufsize-1);
		sp[bufsize-1] = 0;
	}

	//store our character array pointer in a temp var
	char *tempch = q->head->value;
	//as well as our new head (after removal)
	list_ele_t *temp = q->head->next;
	//free the whole struct
	free(q->head);
	//move queue head pointer to new head
    	q->head = temp;
	//and free the char array
	free(tempch);

	(q->size)--;
    /* You need to fix up this code. */
    return true;
}

/*
  Return number of elements in queue.
  Return 0 if q is NULL or empty
 */
int q_size(queue_t *q)
{
	if (q == NULL) {
	return 0;
	}
    /* You need to write the code for this function */
    /* Remember: It should operate in O(1) time */
    return q->size;
}

/*
  Reverse elements in queue
  No effect if q is NULL or empty
  This function should not allocate or free any list elements
  (e.g., by calling q_insert_head, q_insert_tail, or q_remove_head).
  It should rearrange the existing ones.
 */
void q_reverse(queue_t *q)
{
	if (q == NULL) {
	return;
	} else if (q->size == 0) {
	return;
	}

	//basically what we do here is we keep track of our current, previous and next
	//nodes, making the head our new tail, and while there are still nodes that
	//follow the head, we keep slipping them into the new head position
	list_ele_t *prevnode = NULL;
	list_ele_t *currnode = q->head;
	list_ele_t *currnext = NULL;


	while (currnode != NULL) {
		//currnext will become ptr to real next or null, we will assign this to
		//currnode later to either continue adding to front of list or terminate while
		currnext = currnode->next;
		//the previous node becomes our currnode's next, this is us inserting the
		//current node into the front of the list
		currnode->next = prevnode;
		//move our previous node to what was our current node so that (if needed)
		//we can make it the next of what could potentially be our new head (depending
		//on if the while gets terminated)
		prevnode = currnode;
		//currnode gets the next node in the nonreversed list (as stated prev.)
		//now we will see if we must continue inserting at front or if we can
		//terminate our loop
		currnode = currnext;
	}


	//simple swap to reverse the head and tail pointer in the queue struct
	list_ele_t *temp = q->head;
	q->head = q->tail;
	q->tail = temp;

	//making sure that the new tail doesnt have a ghost next node
	q->tail->next = NULL;









    /* You need to write the code for this function */
}
