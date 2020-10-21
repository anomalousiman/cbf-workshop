package models

sealed trait OperationResult

case object OperationSuccess extends OperationResult
case object OperationFailure extends OperationResult
case object UnknownResult extends OperationResult
