package com.tka.CarChoice_Hub.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "Pin code is required")
    @Pattern(regexp = "\\d{6}", message = "Pin code must be 6 digits")
    @Column(nullable = false)
    private String pinCode;

    @NotNull(message = "Enquiry date is required")
    @Column(nullable = false)
    private LocalDate enquiryDate;

    @NotBlank(message = "Payment method is required")
    @Column(nullable = false)
    private String paymentMethod;

    private String testDriveInterest;

    private LocalDate testDriveDate;

    private String testDriveResult;

    @NotNull(message = "Down payment amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Down payment must be greater than 0")
    @Column(nullable = false)
    private Double downPaymentAmount;

    @NotBlank(message = "Loan provider is required")
    @Column(nullable = false)
    private String loanProvider;

    @Pattern(regexp = "^(Approved|Rejected)$", message = "Loan approval status must be 'Approved' or 'Rejected'")
    @NotBlank(message = "Loan approval status is required")
    @Column(nullable = false)
    private String loanApprovalStatus;

    private Double monthlyInstallmentBudget;

    private String customerCategory;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Car car;
}
